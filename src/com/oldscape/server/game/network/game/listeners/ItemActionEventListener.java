/**
 * Copyright (c) 2015 Kyle Friz
 * <p>
 * ChatCrownType is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.oldscape.server.game.network.game.listeners;

import com.oldscape.server.game.model.entity.item.equip.Equipment;
import com.oldscape.server.game.model.entity.item.Item;
import com.oldscape.server.game.model.entity.player.Player;
import com.oldscape.server.game.network.game.GameSessionContext;
import com.oldscape.shared.cache.type.items.ItemType;
import com.oldscape.shared.event.EventListener;
import com.oldscape.shared.network.game.event.impl.ItemActionEvent;

/**
 * @author Kyle Friz
 * @date May 4, 2015
 */
public class ItemActionEventListener implements EventListener<ItemActionEvent, GameSessionContext> {

    @Override
    public void onEvent(ItemActionEvent event, GameSessionContext context) {
        Player player = context.getPlayer();
        Item item = player.getInventory().get(event.getSlot());
        if (item == null || item.getId() != item.getId()) {
            System.out.println("Item no longer exist, Please contact administrator about this issue.");
            return;
        }
        player.getInventory().reset(event.getSlot());
        player.getEquipment().set(getSlot(item.getItemType()), item);

        if (item.getItemType().getName().contains("bow"))
            System.out.println("Using Range Combat");
        else if (item.getItemType().getName().contains("staff"))
            System.out.println("Using Magic Combat");
        else
            System.out.println("Using Melee Combat");

        System.out.println(event.getRoot() + ", " + event.getChild() + ", " + event.getId() + ", " + event.getSlot());
    }

    private int getSlot(ItemType definition) {
        if (definition.getName() == null)
            return Equipment.WEAPON;
        String name = definition.getName().toLowerCase();

        if (name.contains("claws"))
            return Equipment.WEAPON;
        if (name.contains("sword"))
            return Equipment.WEAPON;
        if (name.contains("dagger"))
            return Equipment.WEAPON;
        if (name.contains("mace"))
            return Equipment.WEAPON;
        if (name.contains("whip"))
            return Equipment.WEAPON;
        if (name.contains("bow"))
            return Equipment.WEAPON;
        if (name.contains("staff"))
            return Equipment.WEAPON;
        if (name.contains("dart"))
            return Equipment.WEAPON;

        if (name.contains("glove"))
            return Equipment.HANDS;
        if (name.contains("vamb"))
            return Equipment.HANDS;
        if (name.contains("gaunt"))
            return Equipment.HANDS;

        if (name.contains("ring"))
            return Equipment.RING;
        if (name.contains("bracelet"))
            return Equipment.RING;

        if (name.contains("amulet"))
            return Equipment.AMULET;
        if (name.contains("necklace"))
            return Equipment.AMULET;
        if (name.contains("scarf"))
            return Equipment.AMULET;

        if (name.contains("leg"))
            return Equipment.LEGS;
        if (name.contains("bottom"))
            return Equipment.LEGS;
        if (name.contains("skirt"))
            return Equipment.LEGS;

        if (name.contains("body"))
            return Equipment.CHEST;
        if (name.contains("top"))
            return Equipment.CHEST;
        if (name.contains("chest"))
            return Equipment.CHEST;
        if (name.contains("chainmail"))
            return Equipment.CHEST;
        if (name.contains("torso"))
            return Equipment.CHEST;

        if (name.contains("arrow"))
            return Equipment.ARROWS;
        if (name.contains("bolt"))
            return Equipment.ARROWS;

        if (name.contains("shield"))
            return Equipment.SHIELD;
        if (name.contains("defender"))
            return Equipment.SHIELD;
        if (name.contains("book"))
            return Equipment.SHIELD;

        if (name.contains("cape"))
            return Equipment.CAPE;
        if (name.contains("cloak"))
            return Equipment.CAPE;

        if (name.contains("boot"))
            return Equipment.FEET;

        if (name.contains("hat"))
            return Equipment.HAT;
        if (name.contains("helm"))
            return Equipment.HAT;
        if (name.contains("mask"))
            return Equipment.HAT;
        if (name.contains("hood"))
            return Equipment.HAT;
        if (name.contains("coif"))
            return Equipment.HAT;

        return Equipment.WEAPON;
    }

}
