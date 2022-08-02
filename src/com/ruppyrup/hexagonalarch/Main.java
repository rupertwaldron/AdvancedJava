package com.ruppyrup.hexagonalarch;


import com.ruppyrup.hexagonalarch.adapters.input.FileInput;
import com.ruppyrup.hexagonalarch.adapters.input.KeyboardInput;
import com.ruppyrup.hexagonalarch.adapters.output.FileOutput;
import com.ruppyrup.hexagonalarch.adapters.output.TerminalOutput;
import com.ruppyrup.hexagonalarch.core.Converter;
import com.ruppyrup.hexagonalarch.core.IntegerToRomanConverter;
import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanFile;
import com.ruppyrup.hexagonalarch.ports.input.ConvertIntToRomanKeyboard;
import com.ruppyrup.hexagonalarch.ports.output.WriteToFile;
import com.ruppyrup.hexagonalarch.ports.output.WriteToTerminal;
import com.ruppyrup.hexagonalarch.usecases.ConvertInputFromBothUC;
import com.ruppyrup.hexagonalarch.usecases.ConvertInputFromFileUC;
import com.ruppyrup.hexagonalarch.usecases.ConvertInputFromKeyboardUC;

public class Main {

    public static void main(String[] args) {
        // setup the keyboard-terminal usercase
        Converter romanConverter = new IntegerToRomanConverter();
        WriteToTerminal terminalPort = new TerminalOutput();
        ConvertIntToRomanKeyboard keyboardPort = new ConvertInputFromKeyboardUC(romanConverter, terminalPort);
//        KeyboardInput keyInput = new KeyboardInput(keyboardPort);
//        keyInput.fetchFromKeyboard();

        // set up the file input-output usercase
        WriteToFile fileOutPort = new FileOutput();
        ConvertIntToRomanFile fileInPort = new ConvertInputFromFileUC(romanConverter, fileOutPort);
//        FileInput fileInput = new FileInput(fileInPort);
//        fileInput.fetchFromfile();


        // set up the keyboard file input to terminal and file output usercase
        ConvertInputFromBothUC bothPorts = new ConvertInputFromBothUC(romanConverter, fileOutPort,
            terminalPort);
        KeyboardInput keyInput = new KeyboardInput(bothPorts);
        FileInput fileInput = new FileInput(bothPorts);

//        keyInput.fetchFromKeyboard();
        fileInput.fetchFromfile();



//        Output fileOut = new FileOutput();
//        Adapter<String> outputAdapter2 = new OutputAdapter(fileOut);
//        Converter romanConverter2 = new IntegerToRomanConverter();
//        Adapter<Integer> inputAdapter2 = new InputAdapter(romanConverter2, outputAdapter2);
//        Input fileInput = new FileInput(inputAdapter2);
//
//        fileInput.fetch();
    }
}
