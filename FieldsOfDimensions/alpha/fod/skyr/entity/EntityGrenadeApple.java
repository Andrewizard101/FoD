
package alpha.fod.skyr.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenadeApple extends EntityThrowable {
	
	private World world;
	private boolean hasExplode;
	
	public EntityGrenadeApple(World par1World) {
		super(par1World);
		world = par1World;
		hasExplode = false;
	}
	
	public EntityGrenadeApple(World par1World, EntityLiving par2EntityLiving) {
		super(par1World, par2EntityLiving);
		world = par1World;
	}
	
	public EntityGrenadeApple(World par1World, double par2, double par4, double par6) {
		super(par1World, par2, par4, par6);
		world = par1World;
	}
	
	//hits a block or entity
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
		if (par1MovingObjectPosition.entityHit != null && !hasExplode) {
			par1MovingObjectPosition.entityHit.attackEntityFrom(DamageSource.explosion, 6);
			world.createExplosion(null, posX, posY, posZ, 0.5F, false);
			hasExplode=true;
		}
		
		for (int var3 = 0; var3 < 8; ++var3) {
			world.createExplosion(null, posX, posY, posZ, 0.5F, false);
			this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D); //TODO add particles
		}
		
		if (!this.worldObj.isRemote) {
			this.setDead();
		}
	}
}

