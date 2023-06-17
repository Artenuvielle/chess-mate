package de.martinclan.chessmate;

import de.martinclan.chessmate.data.Board;
import de.martinclan.chessmate.data.Piece;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Factory class for creating instances of Piece objects.
 */
public class PieceFactory {
    private static final Map<String, Class<? extends Piece>> availablePieces = findPieceClasses(
            PieceFactory.class.getPackageName() + ".pieces"
    );

    private final Board board;

    /**
     * Constructs a PieceFactory object with the specified board.
     *
     * @param board The board on which the pieces will be placed
     */
    public PieceFactory(Board board) {
        this.board = board;
    }

    /**
     * Creates a new Piece object with the given name.
     *
     * @param pieceName The name of the piece to create
     * @return A new instance of the specified piece
     * @throws RuntimeException If a piece with the given name cannot be produced
     */
    public Piece createPiece(String pieceName) {
        try {
            Class<? extends Piece> pieceClass = availablePieces.get(pieceName);
            if (pieceClass == null) throw new RuntimeException("Could not produce a piece with name: " + pieceName);
            return pieceClass.getDeclaredConstructor(Board.class).newInstance(board);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Class<? extends Piece>> findPieceClasses(String packageName) {
        // Use reflection for finding all classes in the given package extending the abstract class Piece
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = packageName.replace('.', '/');
        List<Class<? extends Piece>> classes = new ArrayList<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(path);

            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File directory = new File(resource.getFile());

                if (directory.exists()) {
                    String[] files = directory.list();
                    if (files != null) {
                        for (String file : files) {
                            if (file.endsWith(".class")) {
                                String className = packageName + '.' + file.substring(0, file.length() - 6);
                                try {
                                    Class<?> foundClass = Class.forName(className);
                                    if (Piece.class.isAssignableFrom(foundClass)) {
                                        classes.add((Class<? extends Piece>) foundClass);
                                    }
                                } catch (ClassNotFoundException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return classes.stream().collect(Collectors.toMap(Class::getSimpleName, Function.identity()));
    }
}
