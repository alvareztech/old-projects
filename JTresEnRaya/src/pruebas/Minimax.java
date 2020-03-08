///*
// * File: Minimax.java
// */
//package pruebas;
//
///**
// *The following file implements the expectiminimax version of the minimax
// *search algorithm, as applied to Backgammon.
// *Source code in Java 1.5.0.2
// *@author: Andriy Baranskyy, Egor Chalubeyeu
// *email: abaransk@sfu.ca and egorc@sfu.ca
// */
//public class Minimax {
//
//    final int NUMBERPLYLOOKAHEAD = 2;
//    private int depthOfGameTree;
//    final int MAXNODE = 0;//Refers to the nodes that are used in the maximum value calculation
//    final int MINDICENODE = 1;//Refers to the nodes that lead to the user's choice of action
//    final int MINNODE = 2;//Refers to the nodes after the user's action is chosen
//    final int MAXDICENODE = 3;//Refers to the nodes that come before computers turn to chose action
//    String[] treeVisualisation;//array containing strings representing tree. Used for testing purposes only.
//    int playerNumber;
//    int highestLevelReached = 0;
//    final boolean PRINTTREE = false;//decide whether to print the tree - for testing purposes
//    /* Creates a new instance of Minimax
//     * The caller must provide the number of the player for whom expectiminimax is implemented
//     */
//
//    public Minimax(int playerNumber) {
//        depthOfGameTree = (this.NUMBERPLYLOOKAHEAD * 2) + 1;
//        this.treeVisualisation = new String[depthOfGameTree + 2];
//        this.treeVisualisation[0] = "";
//        this.playerNumber = playerNumber;
//    }
//    /*Used to print out the array containing tree - used for testing purposes only
//     */
//
//    private void visualiseTree() {
//        System.out.println("\nHere is the decision tree:\n");
//        for (int i = 1; i <= this.highestLevelReached; i++) {
//            System.out.println(this.treeVisualisation[i]);
//        }
//        System.out.println();
//    }
//    /*This function does the lookahead (on the supplied board) and returns the best move.
//     */
//
//    public Move minimaxDecision(BackgammonBoard myBoard) {
//        MoveSet ms = myBoard.getValidMoves(this.playerNumber);
//        DataContainer maximisedChild = maxValue(myBoard, this.MAXNODE, this.depthOfGameTree);
//        if (this.PRINTTREE) {
//            this.visualiseTree();
//        }
//        return ms.getMove(maximisedChild.getIndex());
//    }
//    /*This function is used to evaluate the worst-possible outcome of the oyher player's actions
//     */
//
//    private DataContainer minValue(BackgammonBoard aBoard, int typeOfNode, int callsLeft) {
//        if (typeOfNode != this.MINNODE) {
//            System.err.println("Wrong type passed to minValue");
//            System.exit(1);
//        }
//        callsLeft--;
//        //Need to open bracket here
//        if (this.PRINTTREE) {
//            this.openBracket(this.depthOfGameTree - callsLeft);
//        }
//        float[] valueArray;
//        int otherPlayer;
//        if (this.playerNumber == 0) {
//            otherPlayer = 1;
//        } else {
//            otherPlayer = 0;
//        }
//        MoveSet ms = aBoard.getValidMoves(otherPlayer);
//        valueArray = new float[ms.getSize()];
//        //check whether the other player have any valid moves at all
//        if (valueArray.length == 0) {
//            valueArray = new float[1];
//            if (callsLeft == 1) {
//                valueArray[0] = (new NaiveEvaluation()).boardScore(aBoard, this.playerNumber);
//            } else {
//                valueArray[0] = chanceNode(aBoard, this.MAXDICENODE, callsLeft).getValue();
//            }
//        } //player has valid moves:
//        else {
//            for (int y = 0; y < ms.getSize(); y++) {
//                BackgammonBoard newBoard = (BackgammonBoard) aBoard.clone();
//                newBoard.applyMove(otherPlayer, ms.getMove(y));
//                if (callsLeft == 1) {
//                    valueArray[y] = (new NaiveEvaluation()).boardScore(newBoard, this.playerNumber);
//                } else {
//                    valueArray[y] = chanceNode(newBoard, this.MAXDICENODE, callsLeft).getValue();
//                }
//            }
//        }
//        int locOfMinimum;
//        float minimumValue;
//        locOfMinimum = this.findLocationOfTheMinimum(valueArray);
//        minimumValue = valueArray[locOfMinimum];
//        //Print the actual value, if printing is enabled
//        if (this.PRINTTREE) {
//            this.printValue(this.depthOfGameTree - callsLeft, minimumValue);
//        }
//        return new DataContainer(locOfMinimum, minimumValue);
//    }
//    /*This function processes the expected value produced by the chance nodes
//     */
//
//    private DataContainer chanceNode(BackgammonBoard aBoard, int typeOfNode, int callsLeft) {
//        if (typeOfNode != this.MAXDICENODE && typeOfNode != this.MINDICENODE) {
//            System.err.println("Wrong type of node passed to chanceNode");
//            System.exit(1);
//        }
//        callsLeft--;
//        //Need to open bracket here
//        if (this.PRINTTREE) {
//            this.openBracket(this.depthOfGameTree - callsLeft);
//        }
//
//        float[] valueArray;
//        valueArray = new float[21];
//        for (int i = 0; i < 21; i++) {
//            BackgammonBoard myBoard = (BackgammonBoard) aBoard.clone();
//            if (i < 6) {
//                myBoard.dc1 = 1;
//                myBoard.dc2 = i + 1;
//            } else if (i < 11) {
//                myBoard.dc1 = 2;
//                myBoard.dc2 = i - 4;
//            } else if (i < 15) {
//                myBoard.dc1 = 3;
//                myBoard.dc2 = i - 8;
//            } else if (i < 18) {
//                myBoard.dc1 = 4;
//                myBoard.dc2 = i - 11;
//            } else if (i < 20) {
//                myBoard.dc1 = 5;
//                myBoard.dc2 = i - 13;
//            } else {
//                myBoard.dc1 = 6;
//                myBoard.dc2 = 6;
//            }
//            int otherPlayer = 1 - this.playerNumber;
//            if (callsLeft == 1 || myBoard.hasWon(this.playerNumber) || myBoard.hasWon(otherPlayer)) {
//                valueArray[i] = (new NaiveEvaluation()).boardScore(myBoard, this.playerNumber);
//            } else if (typeOfNode == this.MINDICENODE) {
//                valueArray[i] = minValue(myBoard, this.MINNODE, callsLeft).getValue();
//            } else {
//                valueArray[i] = maxValue(myBoard, this.MAXNODE, callsLeft).getValue();
//            }
//        }
//        float expectedValue;
//        expectedValue = this.generateExpectedValue(valueArray);
//        //Print the actual value
//        if (this.PRINTTREE) {
//            this.printValue(this.depthOfGameTree - callsLeft, expectedValue);
//        }
//        return new DataContainer(0, expectedValue);
//    }
//    /*
//     *The following function is used to calculate the outcomes of the actions made by the
//     *computer.
//     */
//
//    private DataContainer maxValue(BackgammonBoard aBoard, int typeOfNode, int callsLeft) {
//        if (typeOfNode != this.MAXNODE) {
//            System.err.println("Wrong type of node passed to maxValue");
//            System.exit(1);
//        }
//        callsLeft--;
//        //Need to open bracket here
//        if (this.PRINTTREE) {
//            this.openBracket(this.depthOfGameTree - callsLeft);
//        }
//        MoveSet ms = aBoard.getValidMoves(this.playerNumber);
//        float[] valueArray = new float[ms.getSize()];
//        if (valueArray.length == 0) {
//            valueArray = new float[1];
//            if (callsLeft == 1) {
//                valueArray[0] = (new NaiveEvaluation()).boardScore(aBoard, this.playerNumber);
//            } else {
//                valueArray[0] = chanceNode(aBoard, this.MINDICENODE, callsLeft).getValue();
//            }
//        } else {
//            for (int y = 0; y < ms.getSize(); y++) {
//                BackgammonBoard newBoard = (BackgammonBoard) aBoard.clone();
//                newBoard.applyMove(this.playerNumber, ms.getMove(y));
//                if (callsLeft == 1) {
//                    valueArray[y] = (new NaiveEvaluation()).boardScore(newBoard, this.playerNumber);
//                } else {
//                    valueArray[y] = chanceNode(newBoard, this.MINDICENODE, callsLeft).getValue();
//                }
//            }
//        }
//        int locOfMaximum = this.findLocationOfTheMaximum(valueArray);
//        float value = valueArray[locOfMaximum];
//        //Need to write out the value here
//        if (this.PRINTTREE) {
//            this.printValue(this.depthOfGameTree - callsLeft, value);
//        }
//        return new DataContainer(locOfMaximum, value);
//    }
//    //this function finds the maximum value in the array and returns its location
//
//    private int findLocationOfTheMaximum(float[] evals) {
//        int locationOfMaximum = 0;
//        float currentMaximum = evals[locationOfMaximum];
//        for (int i = 1; i < evals.length; i++) {
//            if (currentMaximum < evals[i]) {
//                locationOfMaximum = i;
//            }
//        }
//        return locationOfMaximum;
//    }
//    //this function finds the minimum value in the array and returns its location
//
//    private int findLocationOfTheMinimum(float[] evals) {
//        int locationOfMinimum = 0;
//        float currentMinimum = evals[locationOfMinimum];
//        for (int i = 1; i < evals.length; i++) {
//            if (currentMinimum > evals[i]) {
//                locationOfMinimum = i;
//            }
//        }
//        return locationOfMinimum;
//    }
//    //Function used in visualising the tree - it's used to open the bracket to represent a node
//
//    private void openBracket(int currentLevel) {
//        if (currentLevel > this.highestLevelReached) {
//            this.treeVisualisation[currentLevel] = "";
//            this.highestLevelReached = currentLevel;
//        }
//        if (this.treeVisualisation[currentLevel - 1].length() - 1 > this.treeVisualisation[currentLevel].length()) {
//            int difference = this.treeVisualisation[currentLevel].length();
//            for (int i = 0; i < ((this.treeVisualisation[currentLevel - 1]).length() - difference - 1); i++) {
//                this.treeVisualisation[currentLevel] += " ";
//            }
//        }
//        this.treeVisualisation[currentLevel] += "(";
//
//    }
//    /*
//     *The function below produces expected value of chance nodes
//     *It assumes that generally the probability of the dice outcomes
//     *is (1/18) - (NB: Outcome (1,2) is the same as (2,1)),
//     *however the repeated dice rolls(e.g. (1,1)) have a lower probability of (1/36)
//     */
//
//    private float generateExpectedValue(float[] values) {
//        float expectedValue = 0.0F;
//        for (int i = 0; i < 21; i++) {
//            if (i == 0 || i == 6 || i == 11 || i == 15 || i == 18 || i == 20) {
//                expectedValue += values[i] * (1.0F / 36.0F);
//            } else {
//                expectedValue += values[i] * (1.0F / 18.0F);
//            }
//        }
//        return expectedValue;
//    }
//    //This function is used to print out a tree - for testing purposes only.
//    //It prints out the value of the node and closes the bracket
//
//    private void printValue(int currentLevel, float value) {
//        String toBeAdded = Float.toString(value) + ")";
//        int lengthToBeAdded = toBeAdded.length();
//        if (((this.treeVisualisation[currentLevel].length() - lengthToBeAdded) >= 0) && this.treeVisualisation[currentLevel].charAt(this.treeVisualisation[currentLevel].length() - 1) != '(') {
//            this.treeVisualisation[currentLevel] = this.treeVisualisation[currentLevel].substring(0, (this.treeVisualisation[currentLevel].length() - lengthToBeAdded));
//        }
//        this.treeVisualisation[currentLevel] += toBeAdded;
//        for (int i = 1; i < currentLevel; i++) {
//            int length = this.treeVisualisation[i].length();
//            for (int y = 0; y < (this.treeVisualisation[currentLevel].length() - length); y++) {
//                this.treeVisualisation[i] += " ";
//            }
//        }
//    }
//}
