package com.acrylic.version_latest.Utils.Directions;

import lombok.Getter;

@Getter
public enum DirectionEnum {

    NORTH("North",90),
    EAST("East",180),
    SOUTH("South",270),
    WEST("West",0),
    NORTH_EAST("North East",NORTH, EAST),
    NORTH_WEST("North West",NORTH, WEST),
    SOUTH_EAST("South East",SOUTH, EAST),
    SOUTH_WEST("South West",SOUTH),
    NORTH_WEST_WEST("North West West",WEST, NORTH_WEST),
    NORTH_NORTH_WEST("North North West",NORTH, NORTH_WEST),
    NORTH_NORTH_EAST("North North East",NORTH, NORTH_EAST),
    NORTH_EAST_EAST("North East East",EAST, NORTH_EAST),
    SOUTH_EAST_EAST("South East East",EAST, SOUTH_EAST),
    SOUTH_SOUTH_EAST("South South East",SOUTH, SOUTH_EAST),
    SOUTH_SOUTH_WEST("South South West",SOUTH, SOUTH_WEST),
    SOUTH_WEST_WEST("South West West",SOUTH_WEST)
    ;

    private final float newUnit = 360F / 32;

    private final float angle1;
    private final float angle2;
    private final float angle;
    private final String string;

    DirectionEnum(String string, float angle) {
        this.angle = angle;
        this.angle1 = angle - newUnit;
        this.angle2 = angle + newUnit;
        this.string = string;
    }

    DirectionEnum(String string, DirectionEnum direction1, DirectionEnum direction2) {
        float angle = (direction1.getAngle() + direction2.getAngle()) / 2;
        this.angle = angle;
        this.angle1 = angle - newUnit;
        this.angle2 = angle + newUnit;
        this.string = string;
    }

    DirectionEnum(String string, DirectionEnum direction) {
        float angle = (direction.getAngle() + 360) / 2;
        this.angle = angle;
        this.angle1 = angle - newUnit;
        this.angle2 = angle + newUnit;
        this.string = string;
    }

}
