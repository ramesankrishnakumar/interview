package interview.easy;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom252 {
	class Solution {

		public boolean canAttendMeetings(int[][] intervals) {
			if (null == intervals || intervals.length <= 1)
				return true;
			Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
			int meetingEnd = intervals[0][1];
			for (int i = 1; i < intervals.length; i++) {
				int newEventStart = intervals[i][0];
				if (newEventStart < meetingEnd)
					return false;
				meetingEnd = intervals[i][1];
			}
			return true;
		}
	}
}
