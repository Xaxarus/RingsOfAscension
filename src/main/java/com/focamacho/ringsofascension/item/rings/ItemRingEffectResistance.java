package com.focamacho.ringsofascension.item.rings;

import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;

public class ItemRingEffectResistance extends ItemRingBase {

    private StatusEffect effect;

    public ItemRingEffectResistance(String name, int tier, StatusEffect effect, String tooltip, boolean enabled, String locations) {
        super(name, tier, tooltip, enabled, locations);
        this.effect = effect;
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        super.tick(player, stack);
        if(player.hasStatusEffect(effect)) {
            player.removeStatusEffect(effect);
        }
    }

}