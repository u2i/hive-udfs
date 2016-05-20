/**
 Based on example from:
 http://svn.apache.org/repos/asf/hive/trunk/contrib/src/java/org/apache/hadoop/hive/contrib/udaf/example/UDAFExampleAvg.java
 */
package com.socialguide.hive.udaf;

import org.apache.hadoop.hive.ql.exec.UDAF;
import org.apache.hadoop.hive.ql.exec.UDAFEvaluator;

public final class UDAFChooseCorrectFollowers extends UDAF {

    public static class UDAFFollowersState {
        private int followers ;
        private int smallestGroupingId;

        void updateIfGroupingIdSmaller(Integer followers, Integer groupingId) {
            if (groupingId != null && followers != null) {
                if(smallestGroupingId > groupingId){
                    smallestGroupingId = groupingId;
                    this.followers = followers;
                }
            }
        }
    }

    public static class UDAFChooseCorrectFollowersEvaluator implements UDAFEvaluator {

        UDAFFollowersState state;

        public UDAFChooseCorrectFollowersEvaluator() {
            super();
            state = new UDAFFollowersState();
            init();
        }

        public void init() {
            state.followers = -1;
            state.smallestGroupingId = Integer.MAX_VALUE;
        }

        public boolean iterate(Integer followers, Integer groupingId) {
            state.updateIfGroupingIdSmaller(followers, groupingId);
            return true;
        }

        public  UDAFFollowersState terminatePartial() {
            return state.followers == -1 ? null : state;
        }

        public boolean merge(UDAFFollowersState o) {
            if (o != null) {
                state.updateIfGroupingIdSmaller(o.followers, o.smallestGroupingId);
            }
            return true;
        }

        public Integer terminate() {
            return state.followers == -1 ? null : state.followers;
        }
    }

    private UDAFChooseCorrectFollowers() {
        // prevent instantiation
    }

}
