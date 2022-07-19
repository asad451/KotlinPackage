package asad.masood

import Health
import WeekStats

class HelloPackage {
    fun calculateMinutes(health: Health): Int {

        var goal: Int

        if (health.able_to_walk_5_minutes == 0 || health.advised_by_gp_not_to_walk == 1 || health.chest_pain_at_rest == 1 || health.unsteady_when_walking == 1) {
            goal = 0
        } else {
            goal = (health.minutes_per_day+5)*health.days_per_week

            if (health.severe_problem_walking == 1) {
                goal = 3*5
            } else {
                when (health.disease) {
                    "PF","COPD", "CHF", "CHD"-> {
                        if (goal < 35)
                            goal = 35
                    }
                    "ASTHMA" -> {
                        if (goal < 35)
                            goal = 35
                    }
                    "DIABETES_TYPE_2" -> {
                        if (goal < 35)
                            goal = 35
                    }
                }
            }
        }
        return goal
    }

    //Function to calculate next week goal
    fun calculateNextWeekMinutes(week: WeekStats): Int {

        var newGoal = 0

        if (week.previous_week_goal == 0)
            newGoal = 0
        else if (week.minutes_achieved_previous_week < week.previous_week_goal) {
            //println("You haven't met your goal")
            newGoal = week.previous_week_goal
        } else {
            if (week.previous_week_goal == 15 || week.previous_week_goal == 30) {
                newGoal = week.previous_week_goal + 15      //default addition of 15 minutes in previous week goal
            } else {
                if (week.increase_decrease == 1) {
                    if (week.user_proposed_next_week_goal > 150)
                        newGoal = 150
                    else
                        newGoal = week.user_proposed_next_week_goal
                }
                else if (week.increase_decrease == -1) {
                    if (week.user_proposed_next_week_goal < 35)
                        newGoal = 35
                    else
                        newGoal = week.user_proposed_next_week_goal
                }
                else {
                    if (week.user_proposed_next_week_goal >= 150)
                        newGoal = 150
                    else
                        newGoal = week.previous_week_goal + 35          //default addition of 35 minutes in previous week goal
                }

            }

        }

        return newGoal
    }
}