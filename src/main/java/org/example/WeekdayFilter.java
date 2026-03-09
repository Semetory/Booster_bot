package org.example;

class WeekdayFilter implements Filter {
    public void execute(UserContext ctx) {
        int day = ctx.now.getDayOfWeek().getValue();
        if (day <= 5) ctx.tags.add("workday");
        else ctx.tags.add("weekend");
    }
}