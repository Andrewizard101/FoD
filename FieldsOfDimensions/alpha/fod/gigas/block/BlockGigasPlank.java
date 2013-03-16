package alpha.fod.gigas.block;

public class BlockGigasPlank extends Block{
     public BlockCastleSpawner(int par1)
    {
        super(par1, par2, Material.iron);
        this.blockFireSpreadSpeed[this.blockID] = 1;
        this.blockFlammability[this.blockID] = 10;
        //this.setCreativeTab();
    }
    
     public boolean onBlockActivated(World par3World, int par4, int par5, int par6, EntityPlayer par5EntityPlayer, int par7, float par8, float par9, float par10)
     { 
        //par3World.spawnParticle("smoke", par4, par5, par6, 0.0D, 0.0D, 0.0D);
     }
}
