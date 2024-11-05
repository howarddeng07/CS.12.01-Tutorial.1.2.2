public class HiddenWord {
    private String hiddenWord;

    public HiddenWord(String hiddenWord) {
        this.hiddenWord = hiddenWord.toUpperCase();
    }

    public String getHiddenWord() {
        return hiddenWord;
    }

    public String getHint(String guess) {
        if (!guess.equals(guess.toUpperCase())) {
            throw new IllegalArgumentException(
                    "Your guess ( " + guess + " ) does not contain all uppercase letters. Your guess must contain all uppercase letters!"
            );
        }

        if (guess.length() != hiddenWord.length()) {
            throw new IllegalArgumentException(
                    "Your guess ( " + guess + " ) has " + guess.length() + " characters. The hidden word has " + hiddenWord.length() + " characters. Your guess must be a word with " + hiddenWord.length() + " characters!"
            );
        }

        StringBuilder hint = new StringBuilder();

        for (int i = 0; i < hiddenWord.length(); i++) {
            char hiddenChar = hiddenWord.charAt(i);
            char guessChar = guess.charAt(i);

            if (guessChar == hiddenChar) {
                hint.append(hiddenChar);
            } else if (hiddenWord.indexOf(guessChar) != -1) {
                hint.append("+");
            } else {
                hint.append("*");
            }
        }

        return hint.toString();
    }
}