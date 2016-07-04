package com.game.web;

/*Each of the two players has six pits in front of him/her. To the right of the six pits, each player
 has a larger pit, his Kalah or house. At the start of the game, six stones are put In each pit.

 The player who begins picks up all the stones in any of their own pits, and sows the stones on to
 the right, one in each of the following pits, including his own Kalah. No stones are put in the
 opponent's' Kalah. If the players last stone lands in his own Kalah, he gets another turn. This can
 be repeated any number of times before it's the other player's turn.

 when the last stone lands in an own empty pit, the player captures this stone and all stones in
 the opposite pit (the other players' pit) and puts them in his own Kalah.

 The game is over as soon as one of the sides run out of stones. The player who still has stones
 in his/her pits keeps them and puts them in his/hers Kalah. The winner of the game is the player
 who has the most stones in his Kalah.*/

/**
 * The Class StateOfGame.
 */
public class StateOfGame {

	/** The players. */
	private GamePlayer[] players;

	/** The game board. */
	private int[] gameBoard;

	/** The current player. */
	private int currentPlayer;

	/**
	 * Instantiates a new state of game.
	 * 
	 * @param playerNum
	 *            the player num
	 * @param thePlayers
	 *            the the players
	 */
	public StateOfGame(int playerNum, GamePlayer[] thePlayers) {
		int[] startGameBoard = { 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0 };
		initialize(playerNum, thePlayers, startGameBoard);
	}

	/**
	 * Initialize the game.
	 * 
	 * @param playerNum
	 *            the player num
	 * @param thePlayers
	 *            the the players
	 * @param startGameBoard
	 *            the start game board
	 */
	private void initialize(int playerNum, GamePlayer[] thePlayers,
			int[] startGameBoard) {
		gameBoard = new int[14];

		for (int i = 0; i < 14; i++) {
			gameBoard[i] = startGameBoard[i];
		}

		currentPlayer = playerNum;
		players = thePlayers;
	}

	/**
	 * Make move.
	 * 
	 * @param pit
	 *            the pit
	 */
	public void makeMove(int pit) {
		int currentPlayerKalah, oppPlayerKalah;
		int stones;

		if (currentPlayer == 0) {
			currentPlayerKalah = 6;
			oppPlayerKalah = 13;
		} else {
			currentPlayerKalah = 13;
			oppPlayerKalah = 6;
		}

		stones = gameBoard[pit];
		gameBoard[pit] = 0;

		while (stones > 0) {
			pit++;
			if (pit == 14)
				pit = 0;
			if (pit != oppPlayerKalah) {
				gameBoard[pit]++;
				stones--;
			}
		}

		if (pit != currentPlayerKalah) {
			if ((gameBoard[pit] == 1)
					&& (gameBoard[12 - pit] > 0)
					&& ((currentPlayer == 0 && (pit < 6)) || (currentPlayer == 1 && (pit > 6)))) {

				gameBoard[currentPlayerKalah] = gameBoard[currentPlayerKalah]
						+ gameBoard[12 - pit] + 1;
				gameBoard[pit] = gameBoard[12 - pit] = 0;
			}
			currentPlayer = 1 - currentPlayer;
		}
	}

	/**
	 * Gets the score of player A.
	 * 
	 * @return the score A
	 */
	public int getScoreA() {
		int total = 0;

		for (int i = 0; i <= 6; i++)
			total += gameBoard[i];

		return total;

	}

	/**
	 * Gets the score of player B.
	 * 
	 * @return the score B
	 */
	public int getScoreB() {
		int total = 0;

		for (int i = 7; i <= 13; i++)
			total += gameBoard[i];

		return total;

	}

	/**
	 * Game over.
	 * 
	 * @return true, if successful
	 */
	// The game is over as soon as one of the sides run out of stones.
	public boolean gameOver() {

		int i = currentPlayer * 7;
		int j = i + 6;

		while (i < j) {
			i++;
			if (gameBoard[i] > 0)
				return false;
		}
		return true;
	}

	/**
	 * Gets the board.
	 * 
	 * @return the board
	 */
	public int[] getBoard() {
		return gameBoard;
	}

	/**
	 * Gets the players.
	 * 
	 * @return the players
	 */
	public GamePlayer[] getPlayers() {
		return players;
	}

	/**
	 * Gets the current player.
	 * 
	 * @return the current player
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}

}