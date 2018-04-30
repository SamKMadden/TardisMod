package net.tardis.mod.models.console;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ConsoleModel extends ModelBase
{
	//fields
		ModelRenderer CentralShaft;
		ModelRenderer Base;
		ModelRenderer Arm1;
		ModelRenderer Arm2;
		ModelRenderer Arm3;
		ModelRenderer Arm4;
		ModelRenderer Face1;
		ModelRenderer Face2;
		ModelRenderer Face3;
		ModelRenderer Face4;
	
	public ConsoleModel()
	{
		textureWidth = 256;
		textureHeight = 256;
		
		CentralShaft = new ModelRenderer(this, 0, 0);
		CentralShaft.addBox(-8F, 0F, -8F, 16, 32, 16);
		CentralShaft.setRotationPoint(0F, -8F, 0F);
		CentralShaft.setTextureSize(256, 256);
		CentralShaft.mirror = true;
		setRotation(CentralShaft, 0F, 0F, 0F);
		Base = new ModelRenderer(this, 0, 100);
		Base.addBox(-24F, 0F, -24F, 48, 1, 48);
		Base.setRotationPoint(0F, 7F, 0F);
		Base.setTextureSize(256, 256);
		Base.mirror = true;
		setRotation(Base, 0F, 0F, 0F);
		Arm1 = new ModelRenderer(this, 0, 50);
		Arm1.addBox(-0.5F, 0F, -0.5F, 1, 27, 1);
		Arm1.setRotationPoint(-7F, -7F, -7F);
		Arm1.setTextureSize(256, 256);
		Arm1.mirror = true;
		Arm2 = new ModelRenderer(this, 0, 50);
		Arm2.addBox(-0.5F, 0F, -0.5F, 1, 27, 1);
		Arm2.setRotationPoint(-7F, -7F, 7F);
		Arm2.setTextureSize(256, 256);
		Arm2.mirror = true;
		Arm3 = new ModelRenderer(this, 0, 50);
		Arm3.addBox(-0.5F, 0F, -0.5F, 1, 27, 1);
		Arm3.setRotationPoint(7F, -7F, 7F);
		Arm3.setTextureSize(256, 256);
		Arm3.mirror = true;
		Arm4 = new ModelRenderer(this, 0, 50);
		Arm4.addBox(-0.5F, 0F, -0.5F, 1, 27, 1);
		Arm4.setRotationPoint(7F, -7F, -7F);
		Arm4.setTextureSize(256, 256);
		Arm4.mirror = true;
		Face1 = new ModelRenderer(this, 8, 50);
		Face1.addBox(-23F, 0F, 0F, 46, 21, 1);
		Face1.setRotationPoint(0F, -6F, 7F);
		Face1.setTextureSize(256, 256);
		Face1.mirror = true;
		setRotation(Face1, 0.837758F, 0F, 0F);
		Face2 = new ModelRenderer(this, 8, 50);
		Face2.addBox(-23F, 0F, 0F, 46, 21, 1);
		Face2.setRotationPoint(0F, -6F, -7F);
		Face2.setTextureSize(256, 256);
		Face2.mirror = true;
		setRotation(Face2, 0.837758F, 3.141593F, 0F);
		Face3 = new ModelRenderer(this, 8, 50);
		Face3.addBox(-23F, 0F, 0F, 46, 21, 1);
		Face3.setRotationPoint(-7F, -6F, 0F);
		Face3.setTextureSize(256, 256);
		Face3.mirror = true;
		setRotation(Face3, 0.837758F, -1.570796F, 0F);
		Face4 = new ModelRenderer(this, 8, 50);
		Face4.addBox(-23F, 0F, 0F, 46, 21, 1);
		Face4.setRotationPoint(7F, -6F, 0F);
		Face4.setTextureSize(256, 256);
		Face4.mirror = true;
		setRotation(Face4, 0.837758F, 1.570796F, 0F);
		double downAmount = -58;
		double spinAmount = 45;
		setRotation(Arm1, (float)Math.toRadians(downAmount), (float)Math.toRadians(spinAmount), (float)Math.toRadians(0));
		setRotation(Arm2, (float)Math.toRadians(downAmount), (float)Math.toRadians(90 + spinAmount), (float)Math.toRadians(0));
		setRotation(Arm3, (float)Math.toRadians(downAmount), (float)Math.toRadians(-90 - spinAmount), (float)Math.toRadians(0));
		setRotation(Arm4, (float)Math.toRadians(downAmount), (float)Math.toRadians(-spinAmount), (float)Math.toRadians(0));
	}
	
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		CentralShaft.render(f5);
		Base.render(f5);
		Arm1.render(f5);
		Arm2.render(f5);
		Arm3.render(f5);
		Arm4.render(f5);
		Face1.render(f5);
		Face2.render(f5);
		Face3.render(f5);
		Face4.render(f5);
	}
	
	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}
	
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e)
	{
		
		/*setRotation(Arm1, (float)Math.toRadians(-(180-roundAmount)), (float)Math.toRadians(rollAmount), (float)Math.toRadians(180-downAmount));
		setRotation(Arm2, (float)Math.toRadians(180-roundAmount), (float)Math.toRadians(rollAmount), (float)Math.toRadians(180-downAmount));
		setRotation(Arm3, (float)Math.toRadians(roundAmount), (float)Math.toRadians(rollAmount), (float)Math.toRadians(downAmount));
		setRotation(Arm4, (float)Math.toRadians(-roundAmount), (float)Math.toRadians(rollAmount), (float)Math.toRadians(downAmount));*/
		super.setRotationAngles(f, f1, f2, f3, f4, f5,e);
	}

}
