package pl.venixpll;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RegionalIndicatorGenerator {

    private static final String indicatorTag = ":regional_indicator_%s:";
    private static final HashMap<Integer,String> numberMap = new HashMap<>();

    public static void main(String... args){
        //INIT
        numberMap.put(0,":zero:");
        numberMap.put(1,":one:");
        numberMap.put(2,":two:");
        numberMap.put(3,":three:");
        numberMap.put(4,":four:");
        numberMap.put(5,":five:");
        numberMap.put(6,":six:");
        numberMap.put(7,":seven:");
        numberMap.put(8,":eight:");
        numberMap.put(9,":nine:");
        final Scanner scanner = new Scanner(System.in);
        while(true){
            final String input = scanner.nextLine();
            String output = "";
            for(char c : input.toCharArray()){
                if(Character.isSpaceChar(c)){
                    output += "  ";
                }else if(Character.isDigit(c)) {
                    output += numberMap.get(Integer.parseInt(String.valueOf(c)));
                }else if(Character.isAlphabetic(c)){
                    output += String.format(indicatorTag, String.valueOf(c).toLowerCase()) + " ";
                }
            }
            final StringSelection selection = new StringSelection(output);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,selection);
            System.out.println("Copied to clipboard!");
        }
    }

}
