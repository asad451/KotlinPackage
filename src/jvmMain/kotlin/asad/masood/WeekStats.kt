data class WeekStats (
    val scenario_id: Int,
    val previous_week_goal: Int,
    val minutes_achieved_previous_week: Int,
    val minutes_mvpa: Int,
    val mood: String,
    val default_increase_minutes: Int,
    val algo_proposed_next_week_goal: Int,
    val increase_decrease: Int,
    val user_proposed_next_week_goal: Int
)