package com.game.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


/**
 * The Class GameController.
 */
@Controller
@SessionAttributes("state")
public class GameController {

	/**
	 * Start.
	 * 
	 * @return the start
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getStart() {

		ModelAndView model = new ModelAndView("kalah");

		GamePlayer[] players = new GamePlayer[2];

		players[0] = makePlayer("A");
		players[1] = makePlayer("B");

		StateOfGame state = new StateOfGame(0, players);

		model.addObject("boardArray", state.getBoard());

		model.addObject("state", state);
		model.setViewName("kalah");
		return model;

	}

	/**
	 * Gets the next Move.
	 * 
	 * @param move
	 *            the move
	 * @param state
	 *            the state
	 * @return the kalah data
	 */
	@RequestMapping(value = "/kalah.htm", method = RequestMethod.GET)
	public ModelAndView getNextMove(@RequestParam("move") int move,
			@ModelAttribute("state") StateOfGame state) {

		ModelAndView model = new ModelAndView("kalah");

		model.addObject("boardArray", state.getBoard());
		String endOfGame = null;
		if (!state.gameOver())
			state.makeMove(move);
		else {
			if (state.getScoreA() > state.getScoreB())
				endOfGame = "Player A wins";
			else if (state.getScoreA() < state.getScoreB())
				endOfGame = "Player B wins";
			else
				endOfGame = "Game is Draw";

			model.addObject("endOfGame", endOfGame);
		}

		model.setViewName("kalah");
		model.addObject("state", state);

		return model;

	}

	/**
	 * Make player.
	 * 
	 * @param playerName
	 *            the player name
	 * @return the game player
	 */
	public static GamePlayer makePlayer(String playerName) {
		return new GamePlayer(playerName);
	}

}