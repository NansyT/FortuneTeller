package com.example.fortuneteller;

import com.google.gson.Gson;

public class FortunePresenter {

    Fortune fortune;
    View view;
    JokeApi jokeApi;

    public FortunePresenter(View view) {
        fortune = new Fortune();
        this.view = view;
        jokeApi = new JokeApi();
    }

    public void setFortuneText(String fortuneText) {
        fortune.setFortuneText(fortuneText);
        view.fortuneTextAdded(fortune.getFortuneText());
    }
    public void GetFortune() {
        Fortune forText = new Gson().fromJson(jokeApi.getJoke(),Fortune.class);
        setFortuneText(forText.getFortuneText());
    }

    public interface View {

        public void fortuneTextAdded(String fortuneText);

    }
}
