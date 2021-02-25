package com.github.highright1234.duel;

import org.bukkit.entity.Player;
import org.projecttl.plugin.duel.DuelPlugin;

import static com.github.highright1234.duel.InviteHashMap.sendHashMap;

public class DuelSend {

    private static final Before before = new Before(new DuelPlugin());


    public static void duel_send(Player sender, Player recipient) {
        if (sendHashMap.get(sender) == null) {
            sendHashMap.put(sender, recipient);
            sender.sendMessage("이미 "+sendHashMap.get(sender)+"님에게 듀얼신청을 보넸습니다");
            recipient.sendMessage("========================="); // 이거 해주세요 ^^7
            recipient.sendMessage(sender.getName()+"님이 듀얼신청을 하였습니다");
            recipient.sendMessage("=========================");
        } else {
            sender.sendMessage("이미 "+sendHashMap.get(sender)+"님에게 듀얼신청을 했습니다!");
        }
    }
    public static void duel_deny(Player sender, Player recipient) {
        if (sendHashMap.get(sender) == recipient) {
            sendHashMap.remove(sender);
            recipient.sendMessage("이미 "+sender.getName()+"님에게 듀얼신청을 보넸습니다");
            sender.sendMessage("========================="); // 이거 해주세요 ^^7
            sender.sendMessage(recipient.getName() + "님이 듀얼신청을 거절하였습니다");
            sender.sendMessage("=========================");
        } else {
            recipient.sendMessage(sender.getName()+"님에게 듀얼신청이 온것이 없습니다!");
        }
    }
    public static void duel_accept(Player sender, Player recipient) {
        if (sendHashMap.get(sender) == recipient) {
            sendHashMap.remove(sender);
            recipient.sendMessage(sender.getName()+"님이 듀얼장소로 이동합니다");
            sender.sendMessage(recipient.getName()+"님이 듀얼장소로 이동합니다"); // 이거 해주세요 ^^7
            before.before_setting(sender, recipient);
        } else {
            recipient.sendMessage(sender.getName()+"님에게 듀얼신청이 온것이 없습니다!");
        }
    }
}
