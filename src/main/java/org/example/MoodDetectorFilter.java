package org.example;

class MoodDetectorFilter implements Filter {
    public void execute(UserContext ctx) {
        if (ctx.messageText.contains("ранн") || ctx.messageText.contains("утро")) ctx.tags.add("morning");
        if (ctx.messageText.contains("ночь") || ctx.messageText.contains("бессон")) ctx.tags.add("night");
        if (ctx.messageText.contains("груст") || ctx.messageText.contains("плохо")) ctx.tags.add("sad");
        if (ctx.messageText.contains("устал") || ctx.messageText.contains("задолбался")) ctx.tags.add("tired");
        if (ctx.messageText.contains("успех") || ctx.messageText.contains("ура")) ctx.tags.add("success");
        if (ctx.messageText.contains("дел") || ctx.messageText.contains("работ")) ctx.tags.add("workday");
    }
}
