data class Health (
    val scenario_id: Int,
    val disease: String,
    val able_to_walk_5_minutes: Int,
    val advised_by_gp_not_to_walk: Int,
    val chest_pain_at_rest: Int,
    val unsteady_when_walking: Int,
    val days_per_week: Int,
    val minutes_per_day: Int,
    val walking_pace: String,
    val no_problem_walking: Int,
    val slight_problem_walking: Int,
    val moderate_problem_walking: Int,
    val severe_problem_walking: Int,
    val recommendation_minutes: Int
)