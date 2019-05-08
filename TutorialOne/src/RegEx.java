public class RegEx {

    public static void main(String[] args) {

        String formatedSentence = formatString("life is like a box of chocolate, you never know what you're going to get.", "is");
        System.out.println(formatedSentence);



    }

    private static String formatString(String sentence, String word) {

        String regex = String.format("\\s*\\b%s\\b\\s*", word);
        String result = sentence.replaceAll(regex, " [    ?    ] ");
//        content = content.replace("is", "");
        System.out.println(result);

        return sentence;
    }
}
