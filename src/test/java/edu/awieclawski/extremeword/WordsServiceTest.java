package edu.awieclawski.extremeword;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class WordsServiceTest {

    private WordsService service = new WordsService();

    @Test
    void findLongestWord() {
        String longest = "longest";
        String input = "Find the " + longest + " word!";
        String output = service.findLongestWord(input);
        Assertions.assertEquals(output, longest);
    }

    @Test
    void findLongestWordInNull() {
        String longest = "";
        String input = null;
        String output = service.findLongestWord(input);
        Assertions.assertEquals(output, longest);
    }

    @Test
    void findShortestWord() {
        String shortest = "the";
        String input = "Find " + shortest + " shortest word!";
        String output = service.findShortestWord(input);
        Assertions.assertEquals(output, shortest);
    }


    @Test
    void findShortestWordInNull() {
        String longest = "";
        String input = null;
        String output = service.findShortestWord(input);
        Assertions.assertEquals(output, longest);
    }

    @Test
    void findShortestWordInSpiteExclamationMark() {
        String shortest = "word";
        String input = "Sentence, final " + shortest + "!";
        String output = service.findShortestWord(input);
        Assertions.assertEquals(output, shortest);
    }

    @Test
    void findShortestWordInSpiteCommaMark() {
        String shortest = "Sentence";
        String input = shortest + ", sentences";
        String output = service.findShortestWord(input);
        Assertions.assertEquals(output, shortest);
    }

    @Test
    void findShortestWordInSpiteEllipsisMark() {
        String shortest = "ops";
        String input = "They said ... " + shortest + "!";
        String output = service.findShortestWord(input);
        Assertions.assertEquals(output, shortest);
    }

}