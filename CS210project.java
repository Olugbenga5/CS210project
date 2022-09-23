import java.util.*;
import java.security.*;
import java.io.*;
public class main {

    public static void main(String[] args) throws IOException
    {
        int result = (stringCompare(sentencegenerator(),sentencegenerator()));
        //when the result is not equal to 64 keep running it
        while(result ==64)
        {
            result =(stringCompare(sentencegenerator(),sentencegenerator()));
        }

        //this prints the sentences generated and the amount of similarities
        System.out.println(sentencegenerator());
        System.out.println(sentencegenerator());
        System.out.println(result);
    }
    public static int stringCompare(String str1, String str2)
    {
        int s1 = str1.length();
        int s2 = str2.length();
        int count = 0;
        String sha1 = sha256(str1),sha2 = sha256(str2);
        for(int i=0;i<sha1.length();i++)
        {
            if(sha1.charAt(i)==sha2.charAt(i))
            {
                count++;
            }
        }
        return count;
    }
    public static String sha256(String input){
        try{
            MessageDigest mDigest = MessageDigest.getInstance("SHA-256");
            byte[] salt = "CS210+".getBytes("UTF-8");
            mDigest.update(salt);
            byte[] data = mDigest.digest(input.getBytes("UTF-8"));
            StringBuffer sb = new StringBuffer();
            for (int i=0;i<data.length;i++)
            {
                sb.append(Integer.toString((data[i]&0xff)+0x100,16).substring(1));
            }
            return sb.toString();
        }
        catch(Exception e){
            return(e.toString());
        }
    }
    public static String sentencegenerator()
    {
        String out ="";
        Random r1 = new Random();
        String beginning[] ={"I","You","cara","Tom","Boy","she","he","dads","mam","Joe","Jack","George","girl","Red" };
        String verbs[] = {" run"," jumps"," talks"," slept"," hate", " love", " follow", " dance", " sing", " walk", " swam", " skip"};
        String noun[] = {"actually","your face","questions","the top", "sister","the rain","brother","laughs","supports","car"};
        String preposition[] = {"away","below","across","above","badly","in front","after","because of","surface","next to","past","by","on","incorrectly","against","in","at","beside","along","towards","close","between","beneath","ahead of","near","around"};

        for(int i = 0; i<1;i++)
        {
            int beginnings= r1.nextInt(beginning.length);
            int verb = r1.nextInt(verbs.length);
            int nouns = r1.nextInt(noun.length);
            int prepositions = r1.nextInt(preposition.length);
            int beginnings1 = r1.nextInt(beginning.length);
            int nouns1 = r1.nextInt(noun.length);



            StringBuilder buffer = new StringBuilder();
            //Here i concated the strings above together
            buffer.append(beginning[beginnings]).append(" "+ noun[nouns]).append(" "+ verbs[verb]).append(" "+ preposition[prepositions]).append(".");

            //Here I made all the first letters of the beginning of my sentence capital while also displaying the sentence through my return statement
            buffer.setCharAt(0, Character.toUpperCase(buffer.charAt(0)));
            out = buffer.toString();
        }
         return out;
    }
}
