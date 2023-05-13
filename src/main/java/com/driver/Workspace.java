package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
        super(emailId, Integer.MAX_VALUE);
        calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        //add the meeting to calendar
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        calendar.sort((a, b) -> {
            if (a.endTime.equals(b.endTime)) {
                if (a.startTime.isBefore(b.startTime))
                    return -1;
                else if (a.startTime.isAfter(b.startTime))
                    return 1;
                else
                    return 0;
            } else {
                if (a.endTime.isBefore(b.endTime))
                    return -1;
                else if (a.endTime.isAfter(b.endTime))
                    return 1;
                else
                    return 0;
            }
        });

        int maxMeetings = 0;
        for (int i = 0; i < calendar.size(); i++) {
            int count = 1;
            LocalTime curStart = calendar.get(i).startTime;
            LocalTime curEnd = calendar.get(i).endTime;

            for (int j = i + 1; j < calendar.size(); j++) {
                if (calendar.get(j).startTime.isAfter(curEnd)) {
                    count++;
                    curEnd = calendar.get(j).endTime;
                }
            }

            maxMeetings = Math.max(maxMeetings, count);
        }
        return maxMeetings;

    }
}
