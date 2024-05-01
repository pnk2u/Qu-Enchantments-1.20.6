package qu.quEnchantments.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;
import org.jetbrains.annotations.Nullable;

public class InaneParticle extends SpriteBillboardParticle {

    private final SpriteProvider spriteProvider;

    public InaneParticle(ClientWorld clientWorld, double x, double y, double z, double dx, double dy, double dz, SpriteProvider spriteProvider) {
        super(clientWorld, x, y, z, dx, dy, dz);
        this.x = x;
        this.y = y;
        this.z = z;
        this.velocityX = dx;
        this.velocityY = dy;
        this.velocityZ = dz;
        this.scale = 0.1f * (this.random.nextFloat() * 0.2f + 0.5f);
        this.maxAge = (int)(Math.random() * 10.0) + 40;
        this.red = 1.0f;
        this.green = 1.0f;
        this.blue = 1.0f;
        this.spriteProvider = spriteProvider;
        this.setSpriteForAge(spriteProvider);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    @Override
    public void tick() {
        super.tick();
        if (this.age++ >= this.maxAge) {
            this.markDead();
            return;
        }
        this.alpha = 1.0f - ((float)this.age / this.maxAge);
        this.setSpriteForAge(this.spriteProvider);
    }

    @Environment(EnvType.CLIENT)
    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Nullable
        @Override
        public Particle createParticle(SimpleParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
            InaneParticle inaneParticle = new InaneParticle(world, x, y, z, velocityY, velocityX, velocityZ, spriteProvider);
            inaneParticle.setSprite(this.spriteProvider);
            return inaneParticle;
        }
    }
}
