package com.drazisil.superbook;

import org.bukkit.OfflinePlayer;
import org.bukkit.scoreboard.*;

public class RulesAgreed implements Objective {
    @Override
    public String getName() throws IllegalStateException {
        return "superbook.has_agreed_to_rules";
    }

    @Override
    public String getDisplayName() throws IllegalStateException {
        return "";
    }

    @Override
    public void setDisplayName(String displayName) throws IllegalStateException, IllegalArgumentException {

    }

    @Override
    public String getCriteria() throws IllegalStateException {
        return "dummy";
    }

    @Override
    public boolean isModifiable() throws IllegalStateException {
        return true;
    }

    @Override
    public Scoreboard getScoreboard() {
        return null;
    }

    @Override
    public void unregister() throws IllegalStateException {

    }

    @Override
    public void setDisplaySlot(DisplaySlot slot) throws IllegalStateException {

    }

    @Override
    public DisplaySlot getDisplaySlot() throws IllegalStateException {
        return null;
    }

    @Override
    public void setRenderType(RenderType renderType) throws IllegalStateException {

    }

    @Override
    public RenderType getRenderType() throws IllegalStateException {
        return null;
    }

    @Override
    public Score getScore(OfflinePlayer player) throws IllegalArgumentException, IllegalStateException {
        return null;
    }

    @Override
    public Score getScore(String entry) throws IllegalArgumentException, IllegalStateException {
        return null;
    }
}
