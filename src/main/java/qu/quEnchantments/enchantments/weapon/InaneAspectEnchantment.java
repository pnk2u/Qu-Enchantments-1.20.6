package qu.quEnchantments.enchantments.weapon;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import qu.quEnchantments.QuEnchantments;
import qu.quEnchantments.enchantments.ModEnchantments;
import qu.quEnchantments.enchantments.QuEnchantment;
import qu.quEnchantments.util.config.ModConfig;
import qu.quEnchantments.util.interfaces.IEntity;

public class InaneAspectEnchantment extends QuEnchantment {

    private static final ModConfig.InaneAspectOptions CONFIG = QuEnchantments.getConfig().inaneAspectOptions;

    public InaneAspectEnchantment(Properties properties) {
        super(properties);
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && (other != Enchantments.FIRE_ASPECT) && (other != ModEnchantments.FREEZING_ASPECT) && (other != ModEnchantments.LEECHING_ASPECT);
    }

/*    @Override
    public int getMinPower(int level) {
        return 10 + 20 * (level - 1);
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return CONFIG.isEnabled ? 2 : 0;
    } */

    @Override
    public boolean isAvailableForRandomSelection() {
        return CONFIG.randomSelection;
    }

    @Override
    public boolean isAvailableForEnchantedBookOffer() {
        return CONFIG.bookOffer;
    }

    @Override
    public boolean isAvailableForEnchantingTable() {
        return CONFIG.enchantingTable;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, ItemStack stack, Entity target, int level) {
        if (user.getWorld().isClient) return;
        ((IEntity)target).setInaneTicks(40 + CONFIG.duration * level);
    }
}
