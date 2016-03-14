/**
 * Copyright (C) 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import models.Game;
import models.Player;
import models.Dealer;

import ninja.Context;
import ninja.Result;
import ninja.Results;

import com.google.inject.Singleton;
import ninja.params.PathParam;


@Singleton
public class ApplicationController {

    public Result Blackjack() {
        return Results.html().template("views/Blackjack/Blackjack.ftl.html");
    }
	
	public Result TheGame() {
        return Results.html().template("views/Blackjack/TheGame.ftl.html");
    }
	
	public Result Money() {
        return Results.html().template("views/Blackjack/Money.html");
    }
	
	public Result Rules() {
        return Results.html().template("views/Blackjack/Rules.html");
    }
	
	public Result index() {
        return Results.html();
    }
	
	public Result header() {
        return Results.html().template("views/layout/header.ftl.html");
    }
	
	public Result footer() {
        return Results.html().template("views/layout/footer.ftl.html");
    }
	
	//public Result audio() {
    //    return Results.html().template("assets/audio/"); add to shortcuts if audio to be added
    //}
	
	public Result gameGet(){
        Game g = new Game();
        //g.buildDeck();
        //g.shuffle();
        //g.dealFour();

        return Results.json().render(g);
    }
	
	public Result dealPost(Context context, Game g) {
        if(context.getRequestPath().contains("deal")){
			g.dealTwo();
			g.play();
        }
        return Results.json().render(g);
    }
	
	public Result hitPost(Context context, Game g) {
        if(context.getRequestPath().contains("hit")){
            g.player.hit(g.deck);
			g.play();
        }
        return Results.json().render(g);
    }
	
	public Result stayPost(Context context, Game g) {
        if(context.getRequestPath().contains("stay")){
            g.player.stand();
			g.play();
        }
        return Results.json().render(g);
    }
	
	public Result splitPost(Context context, Game g) {
        if(context.getRequestPath().contains("split")){
            g.player.split();
			g.play();
        }
        return Results.json().render(g);
    }
	
	public Result doubledPost(Context context, Game g) {
        if(context.getRequestPath().contains("doubled")){
            g.player.doubleDown(g.deck);
			g.player.stand();
			g.play();
        }
        return Results.json().render(g);
    }
    

}
