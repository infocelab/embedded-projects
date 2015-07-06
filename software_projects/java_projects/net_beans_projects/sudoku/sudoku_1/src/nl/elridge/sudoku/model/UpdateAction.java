package nl.elridge.sudoku.model;

/**
 * Enumeration used to inform observers what to update.
 *
 * @author Eric Beijer
 */
public enum UpdateAction {
    NEW_GAME,
    CHECK,
    SELECTED_NUMBER,
    CANDIDATES,
    HELP
}