package com.acrylic.version_latest.Animations;

import com.acrylic.version_latest.Shapes.Circle;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ItemDangle {

    private final static float DEFAULT_RADIUS = 2.5f;
    private final static int DEFAULT_FULL_VIEW_TOTAL = 10;

    @Getter
    private final ArrayList<AbstractAnimations> animators;
    private final Player player;

    @Setter
    private float radius = DEFAULT_RADIUS;
    @Setter
    private int fullView = DEFAULT_FULL_VIEW_TOTAL;



    public ItemDangle(Player p) {
        player = p;
        animators = new ArrayList<>();
    }

    public void addAnimator(AbstractAnimations abstractAnimations) {
        animators.add(abstractAnimations);
    }

    public void delete() {
        animators.forEach(AbstractAnimations::delete);
        animators.clear();
    }

    public void delete(AbstractAnimations abstractAnimation) {
        animators.remove(abstractAnimation);
        abstractAnimation.delete();
    }

    public void update() {
        Location loc = player.getLocation();
        loc.setY(loc.getY() + (radius * loc.getDirection().getY()));
        int size = animators.size();
        float baseDeducedYaw = (size % 2 == 0) ? ((size <= fullView) ? (360f / fullView) : 360f / size) / 2 : 0;
        int count = (size <= fullView) ? fullView : size;
        Circle circle = new Circle(radius,loc,loc.getYaw() + baseDeducedYaw,count);

        AtomicInteger i = new AtomicInteger(-size / 2);
        animators.forEach(abstractAnimations -> {
            Location point = circle.getCirclePoint(i.get());
            abstractAnimations.teleport(point.clone());
            i.addAndGet(1);
        });
    }

}
