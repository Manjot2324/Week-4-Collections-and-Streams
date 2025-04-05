package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class filesTest {
    private static final String test_file = "testfile.txt" ;
    private File_processor file_processor ;

    @BeforeEach
    void setup(){
        file_processor = new File_processor();
    }

    @Test
    void testWriteAndReadFromFile() throws IOException {
        String content = "Hello, Simple" ;
        file_processor.writeToFile(test_file,content);

        String readContent = file_processor.readFromFile(test_file) ;
        assertEquals(content,readContent,"File content should match written content.");
    }
    @Test
    void testFileExistsAfterWriting() throws IOException {
        file_processor.writeToFile(test_file,"Checking file existence");
        assertTrue(Files.exists(Path.of(test_file)), "File should exist after writing");
    }

    @Test
    void testIOExceptionForNonExistentFile(){
        assertThrows(IOException.class, () -> file_processor.readFromFile("test_file.txt") );
    }

    @AfterEach
    void cleanUp() throws IOException{
        Files.deleteIfExists(Path.of(test_file)); //delete the file path when all operations are done
    }


}