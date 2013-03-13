package alpha.fod.skyr.entity;

import alpha.fod.skyr.Skyr;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;

public class EntityBlueSlime extends EntityMob implements IRangedAttackMob {
	public float field_70813_a;
	public float field_70811_b;
	public float field_70812_c;

	/** the time between each jump of the slime */
	private int slimeJumpDelay = 0;

	private boolean evil;

	public EntityBlueSlime(World par1World) {
		super(par1World);
		int var2 = 1 << this.rand.nextInt(3);
		this.yOffset = 0.0F;
		this.slimeJumpDelay = this.rand.nextInt(20) + 10;
		this.setSlimeSize(var2);
		this.texture = "/FoD/Mobs/BlueSlime.png";
		evil = false;

		this.getNavigator().setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAIArrowAttack(this, 0.20F, 20, 12.0F));
		//this.tasks.addTask(2, new EntityAISlimeJump(this, this));
		this.tasks.addTask(3, new EntityAIWander(this, 0.2F));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityLiving.class, 16.0F, 0, true, false, IMob.mobSelector));
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (!this.onGround && this.motionY < 0.0D) {
			this.motionY = ((this.motionY) < 0.0D ? this.motionY + (Math.abs(this.motionY) / 2) : this.motionY); // this.motionY
																													// *=
																													// 0.6D;
		}
		if (Math.abs(this.motionX) < 0.01D) {
			this.motionX = 0.0D;
		}
		if (Math.abs(this.motionY) < 0.01D) {
			this.motionY = 0.0D;
		}
		if (Math.abs(this.motionZ) < 0.01D) {
			this.motionZ = 0.0D;
		}

		if (!worldObj.isDaytime()) {
			evil = true;
		} else {
			evil = false;
		}

	}

	protected void entityInit() {
		super.entityInit();
		this.dataWatcher.addObject(16, new Byte((byte) 1));
	}

	public boolean isAIEnabled() {
		return true;
	}

	protected void setSlimeSize(int par1) {
		this.dataWatcher.updateObject(16, new Byte((byte) par1));
		this.setSize(0.6F * (float) par1, 0.6F * (float) par1);
		this.setPosition(this.posX, this.posY, this.posZ);
		this.setEntityHealth(this.getMaxHealth());
		this.experienceValue = par1;
	}

	public int getMaxHealth() {
		int var1 = this.getSlimeSize();
		return var1 * var1 + 1;
	}

	/**
	 * Returns the size of the slime.
	 */
	public int getSlimeSize() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("Size", this.getSlimeSize() - 1);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
		this.setSlimeSize(par1NBTTagCompound.getInteger("Size") + 1);
	}

	/**
	 * Returns the name of a particle effect that may be randomly created by
	 * EntitySlime.onUpdate()
	 */
	protected String getSlimeParticle() {
		return "slime";
	}

	/**
	 * Returns the name of the sound played when the slime jumps.
	 */
	protected String getJumpSound() {
		return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	public void onUpdate() {
		if (!this.worldObj.isRemote && this.worldObj.difficultySetting == 0 && this.getSlimeSize() > 0) {
			this.isDead = true;
		}

		this.field_70811_b += (this.field_70813_a - this.field_70811_b) * 0.5F;
		this.field_70812_c = this.field_70811_b;
		boolean var1 = this.onGround;
		super.onUpdate();
		int var2;

		if (this.onGround && !var1) {
			var2 = this.getSlimeSize();

			for (int var3 = 0; var3 < var2 * 8; ++var3) {
				float var4 = this.rand.nextFloat() * (float) Math.PI * 2.0F;
				float var5 = this.rand.nextFloat() * 0.5F + 0.5F;
				float var6 = MathHelper.sin(var4) * (float) var2 * 0.5F * var5;
				float var7 = MathHelper.cos(var4) * (float) var2 * 0.5F * var5;
				this.worldObj.spawnParticle(this.getSlimeParticle(), this.posX + (double) var6, this.boundingBox.minY, this.posZ + (double) var7, 0.0D, 0.0D, 0.0D);
			}

			if (this.makesSoundOnLand()) {
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) / 0.8F);
			}

			this.field_70813_a = -0.5F;
		} else if (!this.onGround && var1) {
			this.field_70813_a = 1.0F;
		}

		this.func_70808_l();

		if (this.worldObj.isRemote) {
			var2 = this.getSlimeSize();
			this.setSize(0.6F * (float) var2, 0.6F * (float) var2);
		}
	}

	public void updateEntityActionState() {
		this.despawnEntity();
		EntityPlayer var1 = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);

		if (var1 != null) {
			this.faceEntity(var1, 10.0F, 20.0F);
		}

		if (this.onGround && this.slimeJumpDelay-- <= 0) {
			this.slimeJumpDelay = this.getJumpDelay();

			if (var1 != null) {
				this.slimeJumpDelay /= 3;
			}

			this.isJumping = true;

			if (this.makesSoundOnJump()) {
				this.playSound(this.getJumpSound(), this.getSoundVolume(), ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F) * 0.8F);
			}

			this.moveStrafing = 1.0F - this.rand.nextFloat() * 2.0F;
			this.moveForward = (float) (1 * this.getSlimeSize());
		} else {
			this.isJumping = false;

			if (this.onGround) {
				this.moveStrafing = this.moveForward = 0.0F;
			}
		}
	}

	protected void func_70808_l() {
		this.field_70813_a *= 0.6F;
	}

	/**
	 * Gets the amount of time the slime needs to wait between jumps.
	 */
	protected int getJumpDelay() {
		return this.rand.nextInt(20) + 10;
	}

	protected EntityBlueSlime createInstance() {
		return new EntityBlueSlime(this.worldObj);
	}

	/**
	 * Will get destroyed next tick.
	 */
	public void setDead() {
		int var1 = this.getSlimeSize();

		if (!this.worldObj.isRemote && var1 > 1 && this.getHealth() <= 0) {
			int var2 = 2 + this.rand.nextInt(3);

			for (int var3 = 0; var3 < var2; ++var3) {
				float var4 = ((float) (var3 % 2) - 0.5F) * (float) var1 / 4.0F;
				float var5 = ((float) (var3 / 2) - 0.5F) * (float) var1 / 4.0F;
				EntityBlueSlime var6 = this.createInstance();
				var6.setSlimeSize(var1 / 2);
				var6.setLocationAndAngles(this.posX + (double) var4, this.posY + 0.5D, this.posZ + (double) var5, this.rand.nextFloat() * 360.0F, 0.0F);
				this.worldObj.spawnEntityInWorld(var6);
			}
		}

		super.setDead();
	}

	/**
	 * Called by a player entity when they collide with an entity
	 */
	public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
		if (this.canDamagePlayer()) {
			int var2 = this.getSlimeSize();

			if (this.canEntityBeSeen(par1EntityPlayer) && this.getDistanceSqToEntity(par1EntityPlayer) < 0.6D * (double) var2 * 0.6D * (double) var2 && par1EntityPlayer.attackEntityFrom(DamageSource.causeMobDamage(this), this.getAttackStrength())) {
				this.playSound("mob.attack", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
			}
		}
	}

	/**
	 * Indicates weather the slime is able to damage the player (based upon the
	 * slime's size)
	 */
	protected boolean canDamagePlayer() {
		return evil;
	}

	/**
	 * Gets the amount of damage dealt to the player when "attacked" by the
	 * slime.
	 */
	protected int getAttackStrength() {
		return this.getSlimeSize();
	}

	/**
	 * Returns the sound this mob makes when it is hurt.
	 */
	protected String getHurtSound() {
		return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
	}

	/**
	 * Returns the sound this mob makes on death.
	 */
	protected String getDeathSound() {
		return "mob.slime." + (this.getSlimeSize() > 1 ? "big" : "small");
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId() {
		return this.getSlimeSize() == 1 ? Skyr.blueSlimeball.itemID : 0;
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this
	 * entity.
	 */
	public boolean getCanSpawnHere() {
		Chunk var1 = this.worldObj.getChunkFromBlockCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ));

		if (this.worldObj.getWorldInfo().getTerrainType().handleSlimeSpawnReduction(rand, worldObj)) {
			return false;
		} else {
			if (this.getSlimeSize() == 1 || this.worldObj.difficultySetting > 0) {
				if (this.worldObj.getBiomeGenForCoords(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posZ)) == BiomeGenBase.swampland && this.posY > 50.0D && this.posY < 70.0D && this.worldObj.getBlockLightValue(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ)) <= this.rand.nextInt(8)) {
					return super.getCanSpawnHere();
				}

				if (this.rand.nextInt(10) == 0 && var1.getRandomWithSeed(987234911L).nextInt(10) == 0 && this.posY < 40.0D) {
					return super.getCanSpawnHere();
				}
			}

			return false;
		}
	}

	/**
	 * Returns the volume for the sounds this mob makes.
	 */
	protected float getSoundVolume() {
		return 0.4F * (float) this.getSlimeSize();
	}

	/**
	 * The speed it takes to move the entityliving's rotationPitch through the
	 * faceEntity method. This is only currently use in wolves.
	 */
	public int getVerticalFaceSpeed() {
		return 0;
	}

	/**
	 * Returns true if the slime makes a sound when it jumps (based upon the
	 * slime's size)
	 */
	protected boolean makesSoundOnJump() {
		return this.getSlimeSize() > 0;
	}

	/**
	 * Returns true if the slime makes a sound when it lands after a jump (based
	 * upon the slime's size)
	 */
	protected boolean makesSoundOnLand() {
		return this.getSlimeSize() > 2;
	}

	/*
	 * @Override public void attackEntityWithRangedAttack(EntityLiving var1) {
	 * System.out.println("shot"); EntityBlueSlimeBall var2 = new
	 * EntityBlueSlimeBall(this.worldObj, this.posX, this.posY, this.posZ,
	 * var1);
	 * 
	 * this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() *
	 * 0.4F + 0.8F)); //if(canAttack){ this.worldObj.spawnEntityInWorld(var2);
	 * attackDelay = 0; canAttack = false; // }
	 * 
	 * }
	 */

	public void attackEntityWithRangedAttack(EntityLiving par1EntityLiving) {
		if (evil) {
			EntityBlueSlimeBall var2 = new EntityBlueSlimeBall(this.worldObj, this);
			double var3 = par1EntityLiving.posX - this.posX;
			double var5 = par1EntityLiving.posY + (double) par1EntityLiving.getEyeHeight() - 1.100000023841858D - var2.posY;
			double var7 = par1EntityLiving.posZ - this.posZ;
			float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
			var2.setThrowableHeading(var3, var5 + (double) var9, var7, 1.6F, 12.0F);
			this.playSound("random.bow", 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
			this.worldObj.spawnEntityInWorld(var2);
		}
	}

}
