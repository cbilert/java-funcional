package br.com.digital.innovation.one;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReadFile {


    public static void main(String[] args) throws IOException {
        List<String> cnes = Collections.emptyList();
        String path = "/home/celk/Transferências/cnes.txt";
        cnes = Files.readAllLines(Paths.get(path), StandardCharsets.UTF_8);

        cnes.stream()
                .mapToLong(cnes1 -> Long.valueOf(cnes1))
                .filter(cne ->  cne != 704808504221946L &&
                                cne != 700300980983640L &&
                                cne != 706401144140285L &&
                                cne != 708403290641666L &&
                                cne != 170673346650008L)
                .distinct()
                .sorted()
                .forEach(cn -> System.out.print("'"+cn+"',"));

        System.out.println();
        
        System.out.println(cnes.stream()
                .mapToLong(cnes1 -> Long.valueOf(cnes1))
                .filter(cne ->  cne != 704808504221946L &&
                        cne != 700300980983640L &&
                        cne != 706401144140285L &&
                        cne != 708403290641666L &&
                        cne != 170673346650008L)
                .distinct().count());
    }
}
