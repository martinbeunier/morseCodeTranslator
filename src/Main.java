import java.util.HashMap;

public class Main {
    public static void main(String[] args) {


        HashMap<String, String> charToMorseMap = new HashMap<>();
        charToMorseMap = mapMap();
        HashMap<String, String> morseToCharMap = new HashMap<>();
        morseToCharMap = convertMap(charToMorseMap);

    //String text = "Loop through the items of a .";
    //String text =    "Hlavní nevýhodou ASCII kódu je fakt, že tento kód definuje pouze znaky anglické abecedy – 128 hodnot totiž nedokáže obsáhnout znaky všech národních abeced, které je možno používat v různých jazycích. Z tohoto důvodu byl kód ASCII rozšířen na 8-bitový kód, ve kterém prvních 128 hodnot obsahuje původní ASCII kód a dalších 128 hodnot je možné využít pro znaky specifické pro daný jazyk (většinou tedy znaky s diakritikou). Tato část ASCII kódu není stejná ve všech jazycích, liší se dle použitého kódování.";
        //String text = "to";

        //String text = "Jestli tohle nekdo vylusti a bude prvni dam mu bonbony";
        String text = "Make Modry sip great again .";

    text = text.toUpperCase();

        System.out.println(text);
        text = translateAlphabetToMorse(text, charToMorseMap);
        System.out.println(text);
        text = translateMorseToMachine(text);
        System.out.println(text);
        text = translateMachineToMorse(text);
        System.out.println(text);
        text = translateMorseToAlphabet(text, morseToCharMap);
        System.out.println(text);


    }/////main

    public static HashMap<String, String> convertMap(HashMap<String, String> charToMorseMap){

        HashMap<String, String> morseToCharMap = new HashMap<>();
        for (String key : charToMorseMap.keySet()) {
            String value = charToMorseMap.get(key);
            morseToCharMap.put(value, key);
        }
        return morseToCharMap;
    }
    public static String translateMorseToAlphabet(String input,HashMap<String, String> morseToCharMap ){
        String output = "";

        String[] parts = input.split("\\|");
        for (String part : parts) {
           // System.out.println(part);
            if(!part.isEmpty())
            {
                output = output + morseToCharMap.get(part);
            }
            else{
                output = output + " ";
            }
        }

      return output;
    }
    public static String translateAlphabetToMorse(String input,HashMap<String, String> charToMorseMap ){
        String output = "";

        for (int i = 0; i< input.length();i++){

            if(charToMorseMap.get(String.valueOf(input.charAt(i))) != null) {
                output = output + charToMorseMap.get(String.valueOf(input.charAt(i)));
            }
            output = output + "|";
        }
        output = output.substring(0,output.length()-1);

        return output;
    }

    public static String translateMachineToMorse(String input){
        String state = "";
        String output = "";
        String character = "";

        for (int i = 0;i < input.length();i++) {
            //System.out.println(character);
            character = String.valueOf(input.charAt(i));
            switch (state)
            {
                case "":
                    switch (character)
                    {
                        case "1": output = output + ".";state = ".";break;
                        case "2": output = output + "-";state = "-";break;
                        case "3": output = output + "";state = "";break;
                    }
                break;
                case ".":
                    switch (character)
                    {
                        case "2": output = output + ".";state = ".";break;
                        case "1": output = output + "-";state = "-";break;
                        case "3": output = output + "|";state = "|";break;
                    }
                break;
                case "-":
                    switch (character)
                    {
                        case "3": output = output + ".";state = ".";break;
                        case "2": output = output + "-";state = "-";break;
                        case "1": output = output + "|";state = "|";break;
                    }
                break;
                case "|":

                    switch (character)
                    {
                        case "1": output = output + ".";state = ".";break;
                        case "3": output = output + "-";state = "-";break;
                        case "2": output = output + "|";state = "|";break;
                    }
                break;
            }
        }
        return output;
    }

    public static String translateMorseToMachine(String input){
        String state = "";
        String output = "";
        String character = "";

        for (int i = 0;i < input.length();i++) {
            //System.out.println(character);
            character = String.valueOf(input.charAt(i));
            switch (state)
            {
                case "":
                    switch (character)
                    {
                        case ".": output = output + "1";state = ".";break;
                        case "-": output = output + "2";state = "-";break;
                        case "": output = output + "1";state = "";break;
                    }
                    break;
                case ".":
                    switch (character)
                    {
                        case ".": output = output + "2";state = ".";break;
                        case "-": output = output + "1";state = "-";break;
                        case "|": output = output + "3";state = "|";break;
                    }
                    break;
                case "-":
                    switch (character)
                    {
                        case ".": output = output + "3";state = ".";break;
                        case "-": output = output + "2";state = "-";break;
                        case "|": output = output + "1";state = "|";break;
                    }
                    break;
                case "|":

                    switch (character)
                    {
                        case ".": output = output + "1";state = ".";break;
                        case "-": output = output + "3";state = "-";break;
                        case "|": output = output + "2";state = "|";break;
                    }
                    break;
            }
        }
        return output;
    }

 public static  HashMap<String, String> mapMap(){
     HashMap<String, String> charToMorseMap = new HashMap<>();

        charToMorseMap.put("A", ".-");
        charToMorseMap.put("B", "-...");
        charToMorseMap.put("C", "-.-.");
        charToMorseMap.put("D", "-..");
        charToMorseMap.put("E", ".");
        charToMorseMap.put("F", "..-.");
        charToMorseMap.put("G", "--.");
        charToMorseMap.put("H", "....");
        charToMorseMap.put("I", "..");
        charToMorseMap.put("J", ".---");
        charToMorseMap.put("K", "-.-");
        charToMorseMap.put("L", ".-..");
        charToMorseMap.put("M", "--");
        charToMorseMap.put("N", "-.");
        charToMorseMap.put("O", "---");
        charToMorseMap.put("P", ".--.");
        charToMorseMap.put("Q", "--.-");
        charToMorseMap.put("R", ".-.");
        charToMorseMap.put("S", "...");
        charToMorseMap.put("T", "-");
        charToMorseMap.put("U", "..-");
        charToMorseMap.put("V", "...-");
        charToMorseMap.put("W", ".--");
        charToMorseMap.put("X", "-..-");
        charToMorseMap.put("Y", "-.--");
        charToMorseMap.put("Z", "--..");
// Čísla 0-9
        charToMorseMap.put("0", "-----");
        charToMorseMap.put("1", ".----");
        charToMorseMap.put("2", "..---");
        charToMorseMap.put("3", "...--");
        charToMorseMap.put("4", "....-");
        charToMorseMap.put("5", ".....");
        charToMorseMap.put("6", "-....");
        charToMorseMap.put("7", "--...");
        charToMorseMap.put("8", "---..");
        charToMorseMap.put("9", "----.");

        return charToMorseMap;
    }
    public static  HashMap<String, String> mapMap2 (){
        HashMap<String, String> charToMorseMap = new HashMap<>();

        charToMorseMap.put("E", ".");
        charToMorseMap.put("T", "-");

        charToMorseMap.put("I", "..");
        charToMorseMap.put("A", ".-");
        charToMorseMap.put("N", "-.");
        charToMorseMap.put("M", "--");

        charToMorseMap.put("S", "...");
        charToMorseMap.put("U", "..-");
        charToMorseMap.put("R", ".-.");
        charToMorseMap.put("W", ".--");
        charToMorseMap.put("D", "-..");
        charToMorseMap.put("K", "-.-");
        charToMorseMap.put("G", "--.");
        charToMorseMap.put("O", "---");

        charToMorseMap.put("H", "....");
        charToMorseMap.put("V", "...-");
        charToMorseMap.put("F", "..-.");
       // charToMorseMap.put("", "..--");
        charToMorseMap.put("L", ".-..");
       // charToMorseMap.put("", ".-.-");
        charToMorseMap.put("P", ".--.");
        charToMorseMap.put("J", ".---");
        charToMorseMap.put("B", "-...");
        charToMorseMap.put("X", "-..-");
        charToMorseMap.put("C", "-.-.");
        charToMorseMap.put("Y", "-.--");
        charToMorseMap.put("Z", "--..");
        charToMorseMap.put("Q", "--.-");
      //  charToMorseMap.put("", "---.");
       // charToMorseMap.put("", "----");

// Čísla 0-9
        charToMorseMap.put("0", "-----");
        charToMorseMap.put("1", ".----");
        charToMorseMap.put("2", "..---");
        charToMorseMap.put("3", "...--");
        charToMorseMap.put("4", "....-");
        charToMorseMap.put("5", ".....");
        charToMorseMap.put("6", "-....");
        charToMorseMap.put("7", "--...");
        charToMorseMap.put("8", "---..");
        charToMorseMap.put("9", "----.");

        return charToMorseMap;
    }
    public static  HashMap<String, String> mapMap3 (){
        HashMap<String, String> charToMorseMap = new HashMap<>();

        //2^1
        charToMorseMap.put("E", ".");
        charToMorseMap.put("T", "-");
        //2^2
        charToMorseMap.put("I", "..");
        charToMorseMap.put("A", ".-");
        charToMorseMap.put("N", "-.");
        charToMorseMap.put("M", "--");
        //2^3
        charToMorseMap.put("S", "...");
        charToMorseMap.put("U", "..-");
        charToMorseMap.put("R", ".-.");
        charToMorseMap.put("W", ".--");
        charToMorseMap.put("D", "-..");
        charToMorseMap.put("K", "-.-");
        charToMorseMap.put("G", "--.");
        charToMorseMap.put("O", "---");
        //2^4
        charToMorseMap.put("H", "....");
        charToMorseMap.put("V", "...-");
        charToMorseMap.put("F", "..-.");
        charToMorseMap.put("!", "..--");
        charToMorseMap.put("L", ".-..");
        charToMorseMap.put("?", ".-.-");
        charToMorseMap.put("P", ".--.");
        charToMorseMap.put("J", ".---");
        charToMorseMap.put("B", "-...");
        charToMorseMap.put("X", "-..-");
        charToMorseMap.put("C", "-.-.");
        charToMorseMap.put("Y", "-.--");
        charToMorseMap.put("Z", "--..");
        charToMorseMap.put("Q", "--.-");
        charToMorseMap.put(",", "---.");
        charToMorseMap.put(".", "----");

        //2^5
        charToMorseMap.put("5", ".....");
        charToMorseMap.put("4", "....-");
        charToMorseMap.put("Ě", "...-.");
        charToMorseMap.put("3", "...--");
        charToMorseMap.put("Š", "..-..");
        charToMorseMap.put("Č", "..-.-");
        charToMorseMap.put("Ř", "..--.");
        charToMorseMap.put("2", "..---");
        charToMorseMap.put("Ž", ".-...");
        charToMorseMap.put("Ý", ".-..-");
        charToMorseMap.put("Á", ".-.-.");
        charToMorseMap.put("Í", ".-.--");
        charToMorseMap.put("É", ".--..");
        charToMorseMap.put("Ď", ".--.-");
        charToMorseMap.put("Ň", ".---.");
        charToMorseMap.put("1", ".----");

        charToMorseMap.put("6", "-....");
        charToMorseMap.put("Ť", "-...-");
        charToMorseMap.put("Ů", "-..-.");
        charToMorseMap.put("\n", "-..--");
        charToMorseMap.put("+", "-.-..");
        charToMorseMap.put("-", "-.-.-");
        charToMorseMap.put("*", "-.--.");
        charToMorseMap.put("/", "-.---");
        charToMorseMap.put("7", "--...");
        charToMorseMap.put("=" , "--..-");
        charToMorseMap.put("(", "--.-.");
        charToMorseMap.put(")", "--.--");
        charToMorseMap.put("8", "---..");
        charToMorseMap.put("@", "---.-");
        charToMorseMap.put("9", "----.");
        charToMorseMap.put("0", "-----");
        //2^6
        charToMorseMap.put("#", "......");
        charToMorseMap.put("§", ".....-");
        charToMorseMap.put("&", "...-..");
        charToMorseMap.put("|", "...-.-");
        charToMorseMap.put(":", "...--.");
        charToMorseMap.put(";", "...---");
        charToMorseMap.put("<", "..-...");
        charToMorseMap.put(">", "..-..-");
        charToMorseMap.put("[", "..-.-.");
        charToMorseMap.put("]", "..-.--");
        charToMorseMap.put("^", "..--..");
        charToMorseMap.put("_", "..--.-");
        charToMorseMap.put("{", "..---.");
        charToMorseMap.put("}", "..----");

        charToMorseMap.put("Ó", ".-....");
        charToMorseMap.put("–", ".-...-");
        /*charToMorseMap.put("", ".-..-.");
        charToMorseMap.put("", ".-..--");
        charToMorseMap.put("", ".-.-..");
        charToMorseMap.put("", ".-.-.-");
        charToMorseMap.put("", ".-.--.");
        charToMorseMap.put("", ".-.---");
        charToMorseMap.put("", ".--...");
        charToMorseMap.put("" ,".--..-");
        charToMorseMap.put("", ".--.-.");
        charToMorseMap.put("", ".--.--");
        charToMorseMap.put("", ".---..");
        charToMorseMap.put("", ".---.-");
        charToMorseMap.put("", ".----.");
        charToMorseMap.put("", ".-----");

        charToMorseMap.put("", "-.....");
        charToMorseMap.put("", "-....-");
        charToMorseMap.put("", "-...-.");
        charToMorseMap.put("", "-...--");
        charToMorseMap.put("", "-..-..");
        charToMorseMap.put("", "-..-.-");
        charToMorseMap.put("", "-..--.");
        charToMorseMap.put("", "-..---");
        charToMorseMap.put("", "-.-...");
        charToMorseMap.put("", "-.-..-");
        charToMorseMap.put("", "-.-.-.");
        charToMorseMap.put("", "-.-.--");
        charToMorseMap.put("", "-.--..");
        charToMorseMap.put("", "-.--.-");
        charToMorseMap.put("", "-.---.");
        charToMorseMap.put("", "-.----");

        charToMorseMap.put("", "--....");
        charToMorseMap.put("", "--...-");
        charToMorseMap.put("", "--..-.");
        charToMorseMap.put("", "--..--");
        charToMorseMap.put("", "--.-..");
        charToMorseMap.put("", "--.-.-");
        charToMorseMap.put("", "--.--.");
        charToMorseMap.put("", "--.---");
        charToMorseMap.put("", "---...");
        charToMorseMap.put("" ,"---..-");
        charToMorseMap.put("", ".--.-.");
        charToMorseMap.put("", "---.--");
        charToMorseMap.put("", "----..");
        charToMorseMap.put("", "----.-");
        charToMorseMap.put("", "-----.");
        charToMorseMap.put("", "------");*/

        return charToMorseMap;
    }

}

