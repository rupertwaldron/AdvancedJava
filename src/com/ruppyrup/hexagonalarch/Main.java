package com.ruppyrup.hexagonalarch;


import com.ruppyrup.hexagonalarch.adapters.Adapter;
import com.ruppyrup.hexagonalarch.adapters.InputAdapter;
import com.ruppyrup.hexagonalarch.adapters.OutputAdapter;
import com.ruppyrup.hexagonalarch.core.Converter;
import com.ruppyrup.hexagonalarch.core.IntegerToRomanConverter;
import com.ruppyrup.hexagonalarch.ports.Input;
import com.ruppyrup.hexagonalarch.ports.KeyboardInput;
import com.ruppyrup.hexagonalarch.ports.Output;
import com.ruppyrup.hexagonalarch.ports.TerminalOutput;

public class Main {

    public static void main(String[] args) {
        Output screenOut = new TerminalOutput();
        Adapter<String> outputAdapter = new OutputAdapter(screenOut);
        Converter romanConverter = new IntegerToRomanConverter();
        Adapter<Integer> inputAdapter = new InputAdapter(romanConverter, outputAdapter);
        Input keyInput = new KeyboardInput(inputAdapter);
        keyInput.fetch();

//        Output fileOut = new FileOutput();
//        Adapter<String> outputAdapter2 = new OutputAdapter(fileOut);
//        Converter romanConverter2 = new IntegerToRomanConverter(outputAdapter2);
//        Adapter<Integer> inputAdapter2 = new InputAdapter(romanConverter2);
//        Input fileInput = new FileInput(inputAdapter2);

//        fileInput.fetch();
    }
}