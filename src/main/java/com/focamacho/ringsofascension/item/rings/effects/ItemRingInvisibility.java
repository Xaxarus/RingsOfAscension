package com.focamacho.ringsofascension.item.rings.effects;

import com.focamacho.ringsofascension.config.ConfigHolder;
import com.focamacho.ringsofascension.item.ItemRingBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemRingInvisibility extends ItemRingBase {

    public ItemRingInvisibility(Properties properties, String name, String tooltip) {
        super(properties, name, tooltip);
    }

    @Override
    public void tickCurio(String identifier, int index, LivingEntity livingEntity) {
        if(!ConfigHolder.ringInvisibility) return;
        if(!livingEntity.isPotionActive(Effects.INVISIBILITY)) {
            EffectInstance effectInstance = new EffectInstance(Effects.INVISIBILITY, Integer.MAX_VALUE, ConfigHolder.ringAmplifierInvisibility, false, false);
            if(livingEntity.world.isRemote) effectInstance.setPotionDurationMax(true);
            livingEntity.addPotionEffect(effectInstance);
        }
    }

    @Override
    public void onUnequippedCurio(String identifier, LivingEntity livingEntity) {
        if(!ConfigHolder.ringInvisibility) return;
        livingEntity.removePotionEffect(Effects.INVISIBILITY);
    }

    @Override
    public int getTier() {
        return ConfigHolder.ringTierInvisibility;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if(!ConfigHolder.ringInvisibility) return;
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

}