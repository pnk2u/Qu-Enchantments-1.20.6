package qu.quEnchantments.enchantments.weapon;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import qu.quEnchantments.QuEnchantments;
import qu.quEnchantments.enchantments.ModEnchantments;
import qu.quEnchantments.enchantments.QuEnchantment;
import qu.quEnchantments.util.config.ModConfig;

public class LeechingAspectEnchantment extends QuEnchantment {

    private static final ModConfig.LeechingAspectOptions CONFIG = QuEnchantments.getConfig().leechingAspectOptions;
//  private static final Enchantments enchantment = ;

    public LeechingAspectEnchantment(Properties properties) {
        super(properties);
    }

//    public LeechingAspectEnchantment(String name, Enchantment enchantment) {
//
//    }

    @Override
    public boolean canAccept(Enchantment other) {
            return super.canAccept(other) && other != Enchantments.FIRE_ASPECT && other != ModEnchantments.INANE_ASPECT && other != ModEnchantments.FREEZING_ASPECT;
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
        World world;
        if ((world = user.getWorld()).isClient) return;

        user.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0, false, false, false));
        user.heal(CONFIG.healing * level);

        Random random = world.getRandom();
        double d = random.nextGaussian() * 0.02;
        double e = random.nextGaussian() * 0.02;
        double f = random.nextGaussian() * 0.02;
        ((ServerWorld) world).spawnParticles(ParticleTypes.HEART, user.getParticleX(1.0), user.getRandomBodyY(), user.getParticleZ(1.0), 1, d, e, f, 0.0);
    }
}
