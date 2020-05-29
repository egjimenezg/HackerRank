import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class TagContentExtractor {

  private LinkedList<String> lines;

  public TagContentExtractor(LinkedList<String> lines){
    this.lines = lines;
  }

  private ArrayList<String> getTagsContentInLine(String line){
    ArrayDeque<String> stack = new ArrayDeque<String>();
    ArrayList<String> tagsContent = new ArrayList<String>();

    StringBuilder tag = new StringBuilder();
    StringBuilder tagContent = new StringBuilder();
    Boolean isTagContent, isTag;
    isTagContent = isTag = false;

    for(int position=0; position < line.length(); position++){
      if(line.charAt(position) == '<'){
        tag.setLength(0);
        isTag = true;
      }
      else if(line.charAt(position) == '>' && isTag){
        if(tag.length() > 0){
          if(tag.charAt(0) == '/'){
            String closeTag = tag.toString().substring(1,tag.length());

            if(!stack.isEmpty() && stack.getFirst().equals(closeTag)){
              if(tagContent.length() > 0){
                tagsContent.add(tagContent.toString());
              }
              stack.removeFirst();
            }

            tagContent.setLength(0); 
            isTagContent = false;  
          } else {
            stack.addFirst(tag.toString()); 
            tagContent.setLength(0);
            isTagContent = true; 
          }
        }

        tag.setLength(0);
        isTag = false;
      } else if(isTag){
        tag.append(line.charAt(position));
      } else if(isTagContent){
        tagContent.append(line.charAt(position));
      }
    }

    return tagsContent;
  }

  public LinkedList<String> getValidWords(){
    
    LinkedList<String> words = new LinkedList<>();
    Integer contentLinesNumber = 0;

    for(String line : lines){
      ArrayList<String> tagsContent = getTagsContentInLine(line);
      if(tagsContent.size() > 0)
        words.addAll(tagsContent);
      else
        words.add("None");
    }

    return words;
  }

  public static void main(String... args){
    Scanner scanner = new Scanner(System.in);
    PrintWriter printWriter = new PrintWriter(new BufferedWriter(
      new OutputStreamWriter(System.out)));

    Integer n = Integer.parseInt(scanner.nextLine());

    LinkedList<String> lines = new LinkedList<>();

    while(n > 0){
      String line = scanner.nextLine();
      lines.add(line);
      n--;
    }    

    TagContentExtractor tagExtractor = new TagContentExtractor(lines);
    LinkedList<String> tagsText = tagExtractor.getValidWords();

    for(String text : tagsText){
      printWriter.println(text);
    }

    printWriter.close();
    scanner.close();
  }
}

