package org.example;

class TimeOfDayFilter implements Filter {
    public void execute(UserContext ctx) {
        int hour = ctx.now.getHour();
        if (hour >= 5 && hour < 12) ctx.tags.add("morning");
        else if (hour >= 12 && hour < 18) ctx.tags.add("day");
        else if (hour >= 18 && hour < 23) ctx.tags.add("evening");
        else ctx.tags.add("night");
    }
}
