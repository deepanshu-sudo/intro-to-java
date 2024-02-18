import java.util.Scanner;

public class StringOperation
{
    private String paragraph;

    //constructor
    StringOperation(String paragraph) {
        this.paragraph = paragraph;
    }

    //count characters of paragraph
    public int countChars() {
        return paragraph.length();
    }

    //count words of paragraph
    public int countWords() {
        String tempParagraph = paragraph.replace("\\n","\n");
        tempParagraph = tempParagraph.replace("\n"," ").trim();
        int wc = 0;
        for(char ch : tempParagraph.toCharArray()) {
            if(ch == ' ') {
                wc++;
            }
        }
        return wc+1;
    }

    //count lines in paragraph
    public int countLines() {
        String tempParagraph = paragraph.replace("\\n","\n").trim();
        int lc = 0;
        for(char ch : tempParagraph.toCharArray()) {
            if(ch == '\n') {
                lc++;
            }
        }
        return lc+1;
    }

    //make the entire sentence in sentence case
    public String toSentenceCase() {
        String tempParagraph = paragraph.replace("\\n","\n");
        String[] lines = tempParagraph.split("\n");
        String retVal = "";

        for(String line : lines) {
            line = line.trim().toLowerCase();
            line = line.substring(0, 1).toUpperCase() + line.substring(1);
            retVal = retVal + "\n" + line;
        }
        return retVal;
    }

    //reverse the entire paragraph
    public void reverseParagraph() {
        String tempParagraph = paragraph.replace("\\n","\n");
        char[] tempParagraphArray = tempParagraph.toCharArray();
        
        for(int i = tempParagraphArray.length-1; i >= 0; i--) {
            System.out.print(tempParagraphArray[i]);
        }
    }

    //reverse order of the words 
    public void reverseWordOrder() {
        String tempParagraph = paragraph.replace("\\n"," \n ");
        String[] words = tempParagraph.split(" ");

        for(int i = words.length-1; i >= 0; i--) {
            System.out.print(words[i]);

            if (!words[i].endsWith("\n")) {
                System.out.print(" ");
            }
        }
    }

    // Main Method
    public static void main(String[] args) {
        System.out.println("Enter a String: ");
        Scanner sc = new Scanner(System.in);
        String pg = sc.nextLine();
        StringOperation paragraph = new StringOperation(pg);
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("No. of characters: "+paragraph.countChars());
        System.out.println("No. of words: "+paragraph.countWords());
        System.out.println("No. of lines: "+paragraph.countLines());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("To Sentence Case: "+paragraph.toSentenceCase());
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Reversed Word Order Pararaph: ");
        paragraph.reverseWordOrder();
        System.out.println("\n--------------------------------------------------------------------------");
        System.out.println("Reversed Paragraph: ");
        paragraph.reverseParagraph();
        System.out.println("\n--------------------------------------------------------------------------");
    }
}