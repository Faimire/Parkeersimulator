package logic;

import java.util.*;


//Waiting list for new subscription members
public class MembersWaitingList {
	
	
		public void membersWaitingList() {
			Queue<Integer> member = new LinkedList<>();
			
			if (member.size() < 999 ) {
				member.addAll(member);
				member.addAll(member);
				member.addAll(member);
			}
			else if (member.size() == 150) {
				member.poll();
			}
		}

}
