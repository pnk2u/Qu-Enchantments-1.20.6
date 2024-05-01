package qu.quEnchantments.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.math.BlockPos;

public abstract class QuEnchantment extends Enchantment {
    public QuEnchantment(Properties properties) {
        super(properties);
    }



    public abstract boolean isAvailableForEnchantingTable();

    public float getAttackDamage(Entity target, ItemStack stack, int level) {
        return 0.0f;
    }

    public void tickOnce(LivingEntity entity, ItemStack stack, int level) {}

    public void tickAlways(LivingEntity entity, ItemStack stack, int level) {}

    public void tickWhileEquipped(LivingEntity entity, ItemStack stack, int level) {}

    public void tickEquippedWhileMoving(LivingEntity entity, BlockPos pos, ItemStack stack, int level) {}

    public void onTargetDamaged(LivingEntity user, ItemStack stack, Entity target, int level) {}

    public void onBlock(LivingEntity user, LivingEntity attacker, ItemStack stack, int level) {}

    public void onBlockBreak(PlayerEntity player, BlockPos pos, ItemStack stack, int level) {}
}
