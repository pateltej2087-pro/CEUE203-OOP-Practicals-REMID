import java.util.Scanner;
class FeedbackFormatter{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter sentence: ");
        String sentence=sc.nextLine().trim();
        System.out.print("Enter keyword: ");
        String keyword=sc.nextLine();
        String[] words=sentence.split(" +");
        StringBuilder formatted=new StringBuilder();
        StringBuilder acronym=new StringBuilder();
        String longest="";
        int count=0;
        for (String word : words) {
            String w=word.toLowerCase();
            w=w.substring(0, 1).toUpperCase() + w.substring(1);
            if (formatted.length()>0){
                formatted.append(" ");
            }
            formatted.append(w);
            acronym.append(w.charAt(0));
            if (w.length()>longest.length()){
                longest=w;
            }
            if (word.equalsIgnoreCase(keyword)){
                count++;
            }
        }
        System.out.println("Formatted: " + formatted);
        System.out.println("Words: " + words.length);
        System.out.println("Longest word: " + longest);
        System.out.println("Keyword count: " + count);
        System.out.println("Acronym: " + acronym);
        sc.close();
    }
}