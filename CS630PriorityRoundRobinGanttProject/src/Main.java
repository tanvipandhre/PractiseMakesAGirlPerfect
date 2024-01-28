//PINK TEAM =^.^=

import java.util.*;
public class Main {
	
	public static void main(String[] args) {
		ArrayList<Process> allProcesses = new ArrayList<Process>();
		
		ReadyQueue RQ = new ReadyQueue();
		
		Process p1 = new Process(allProcesses, -1, 2);
		Process p2 = new Process(allProcesses, -1, 3);
		
		RQ.append(p1);
		RQ.append(p2);
		
		int currentlyExecuting = 0;
		Process current = null;
		int time = 0;
		int timeQuantum = 4;
		
		while((RQ.queue.size() > 0) || (currentlyExecuting == 1)) {
			if(currentlyExecuting == 1) {
				current.timeInExecution ++;
				current.TRIQ --;
				current.timeRemaining --;
				
				if(current.timeInExecution % 3 == 0) {
					Process p = current.fork(allProcesses, time);
					if(p!=null) {
						RQ.append(p);
						//System.out.println(p.processID);
					}
				}
				
				if(current.timeRemaining == 0) {
					current.exitTimes.add(time);
					currentlyExecuting = 0;
					//RQ.remove(current);
				}
				
				else if(current.TRIQ == 0) {
					current.exitTimes.add(time);
					currentlyExecuting = 0;
					//RQ.remove(current);
					RQ.append(current);
				}
				
				for(int i = 0; i<allProcesses.size();i++) {
					if(allProcesses.get(i).processID == current.processID) {
						allProcesses.remove(i);
					}
				}
					
				allProcesses.add(current);
				
			}
			
			if(currentlyExecuting == 0) {
				if(RQ.prio1.size()!=0) {
					current = RQ.prio1.get(0);
					current.TRIQ = timeQuantum;
					current.enterTimes.add(time);
					currentlyExecuting = 1;
					
					RQ.remove(current);
					
				}
				else if(RQ.prio2.size()!=0) {
					current = RQ.prio2.get(0);
					current.TRIQ = timeQuantum;
					current.enterTimes.add(time);
					currentlyExecuting = 1;
					RQ.remove(current);
				}
				else if(RQ.prio3.size()!=0) {
					current = RQ.prio3.get(0);
					current.TRIQ = timeQuantum;
					current.enterTimes.add(time);
					currentlyExecuting = 1;
					RQ.remove(current);
				}
				else {
					current = new Process();
				}
				
				
				
			}
			
			if(current.processID != -1) {
			
			if((time%3==0) && (time!=0)) {
				current.signals++;
			}
			
			
			
			//update allProcesses
			for(int i = 0; i<allProcesses.size();i++) {
				if(allProcesses.get(i).processID == current.processID) {
					allProcesses.remove(i);
				}
			}
			

			
			
			
				allProcesses.add(current);
			}
			
			time++;
		}
		
		/*for(int i = 0;i<allProcesses.size();i++) {
		System.out.print("| ");
		System.out.print(allProcesses.get(i).name);
		System.out.println(" |");
		for(int j = 0;j<allProcesses.get(i).enterTimes.size();j++) {
		if(j==0)
		System.out.print( allProcesses.get(i).enterTimes.get(j) + "\t" );
		else if( allProcesses.get(i).exitTimes.get(j-1) != allProcesses.get(i).enterTimes.get(j))
		System.out.print( allProcesses.get(i).enterTimes.get(j) + "\t" );
		System.out.print(allProcesses.get(i).exitTimes.get(j)+"\t");
		}

		System.out.println();
		}*/
		
		System.out.println("The number of signals received by each process is as follows:");
		for(int i = 1;i<=allProcesses.size();i++) {
			for(int j = 0; j < allProcesses.size(); j++) {
				if(allProcesses.get(j).processID == i) {
					System.out.println(allProcesses.get(j).name+": " + allProcesses.get(j).signals);
				}
			}
		}
		System.out.println();
		
		System.out.println("The Gantt chart is as follows:");
		
		int exitTime = 0;
		
		for(int i=0; i<allProcesses.size();i++) {
			for(int j = 0; j<allProcesses.get(i).exitTimes.size();j++) {
				if(allProcesses.get(i).exitTimes.get(j)>exitTime) {
					exitTime = allProcesses.get(i).exitTimes.get(j);
				}
			}
		}
		
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		Map<Integer, String> map = new TreeMap<Integer, String>();
		for(int i = 0; i<allProcesses.size();i++) {
			for(int j=0;j<allProcesses.get(i).enterTimes.size();j++) {
				map.put(allProcesses.get(i).enterTimes.get(j), allProcesses.get(i).name);
			}
		}
		
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			System.out.print("|  ");
			if((entry.getValue().length()) == 3) {
				System.out.print(entry.getValue());
			}
			else {
				System.out.print(" "+entry.getValue());
			}
			
			
			
		}
		System.out.println("|");
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		for(Map.Entry<Integer, String> entry: map.entrySet()) {
			if(entry.getKey()==0) {
				System.out.print(entry.getKey()+"     ");
			}
			else if((entry.getKey() >= 10) && (entry.getKey()<100)) {
			System.out.print(entry.getKey()+"   ");
			System.out.print(" ");
			}
			else {
				System.out.print(entry.getKey()+"     ");
			}
			
			
		}
		System.out.print(exitTime);
		System.out.print("\n");
		
	}
	
	
	public static class Process {
		int processID;
		int priority;
		String name;
		
		int signals;
		int timeInExecution;
		int arrivalTime;
		int burstTime;
		int timeRemaining;
		int TRIQ; //time remaining in quantum
		
		ArrayList<Integer> enterTimes;
		ArrayList<Integer> exitTimes;
		
		public Process() {
			processID = -1;
			priority = -1;
			name = "-1";
			timeInExecution = 0;
			arrivalTime = 0;
			burstTime = 0;
			timeRemaining = 0;
			TRIQ = 0;
			signals = 0;
		}
		
		public Process(ArrayList<Process> pList, int at, int prio) {
			processID = pList.size()+1;
			priority = prio;
			arrivalTime = at;
			timeInExecution = 0;
			
			if(priority==1) {
				burstTime = 5;
			}
			else if(priority == 2) {
				burstTime = 10;
			}
			else if(priority == 3) {
				burstTime = 7;
			}
			
			
			timeRemaining = burstTime;
			TRIQ = 4;
			
			name = "p" + Integer.toString(processID);
			signals = 0;
			
			enterTimes = new ArrayList<Integer>();
			exitTimes = new ArrayList<Integer>();
			pList.add(this);
		}
		
		public Process fork(ArrayList<Process> pList, int at) {
			if (priority==1) {
				return null;
			}
			else if(priority==2) {
				return new Process(pList, at, 3);
			}
			else if(priority==3) {
				return new Process(pList, at, 1);
			}
			
			return null;
		}
	}
	
	 static class ReadyQueue {
			ArrayList<Process> queue;
			ArrayList<Process> prio1;
			ArrayList<Process> prio2;
			ArrayList<Process> prio3;
			
			public ReadyQueue() {
				queue = new ArrayList<Process>();
				prio1 = new ArrayList<Process>();
				prio2 = new ArrayList<Process>();
				prio3 = new ArrayList<Process>();
			}
			
			public void remove(Process p) {
				for (int i = 0; i<queue.size(); i++) {
					if(queue.get(i).processID == p.processID) {
						queue.remove(i);
					}
				}
				
				switch(p.priority) {
				case 1:
					for (int i = 0; i<prio1.size(); i++) {
						if(prio1.get(i).processID == p.processID) {
							prio1.remove(i);
						}
					}
				case 2:
					for (int i = 0; i<prio2.size(); i++) {
						if(prio2.get(i).processID == p.processID) {
							prio2.remove(i);
						}
					}
				case 3:
					for (int i = 0; i<prio3.size(); i++) {
						if(prio3.get(i).processID == p.processID) {
							prio3.remove(i);
						}
					}
				}
			}
			
			public void append(Process p) {
				queue.add(p);
				if (p.priority==1) {
				
					prio1.add(p);
				}
				else if (p.priority== 2) {
					prio2.add(p);
				}
				else if(p.priority==3) {
					prio3.add(p);
				}
			}
		}

}

