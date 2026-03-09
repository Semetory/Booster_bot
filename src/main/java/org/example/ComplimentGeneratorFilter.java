package org.example;

import java.util.*;

class ComplimentGeneratorFilter implements Filter {
    private final Map<String, List<String>> phrases = Map.of(
            "morning", List.of("пусть этот кофе зарядит тебя на весь день!", "утро начинается с побед!"),
            "night", List.of("ты заслужил отдых, спи крепко.", "завтра будет новый шанс!"),
            "sad", List.of("эй, тучи всегда расходятся. Ты сильнее, чем кажешься!", "я рядом, всё наладится."),
            "weekend", List.of("Ого, выходные! 🥂 Самое время перезагрузиться.", "Наслаждайся отдыхом, заслужил!"),
            "success", List.of("красавчик! Студент года прямо передо мной!", "это только начало твоего взлета!"),
            "workday", List.of("учеба — это марафон, и ты отлично бежишь.", "еще немного и выходные!"),
            "tired", List.of("не перетруждайся - не забывай о себе.", "осталось совсем чучуть")
    );

    public String result;

    public void execute(UserContext ctx) {
        // Ищем фразы, подходящие под любой из тегов в контексте
        List<String> pool = new ArrayList<>();
        for (String tag : ctx.tags) {
            if (phrases.containsKey(tag)) pool.addAll(phrases.get(tag));
        }

        // Регрессия: если ничего не нашли, берем общую фразу
        if (pool.isEmpty()) pool = List.of("ты просто молодец!");

        String randomPhrase = pool.get(new Random().nextInt(pool.size()));
        result = ctx.firstName + ", " + randomPhrase;
    }
}
