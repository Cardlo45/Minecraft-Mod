// Made with Blockbench 3.7.1
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public static class Model_Some_Mount extends EntityModel<Entity> {
	private final ModelRenderer Head;
	private final ModelRenderer Body;
	private final ModelRenderer Wing0;
	private final ModelRenderer Wing1;
	private final ModelRenderer Leg0;
	private final ModelRenderer Leg1;
	private final ModelRenderer Leg2;
	private final ModelRenderer Leg3;

	public Model_Some_Mount() {
		textureWidth = 76;
		textureHeight = 76;

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, 5.0F, -11.0F);
		Head.setTextureOffset(0, 25).addBox(-4.0F, -3.5F, -8.0F, 8.0F, 8.0F, 8.0F, 0.0F, false);
		Head.setTextureOffset(12, 43).addBox(-4.5F, -1.5F, -5.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(12, 43).addBox(3.5F, -1.5F, -5.0F, 1.0F, 5.0F, 3.0F, 0.0F, false);
		Head.setTextureOffset(0, 11).addBox(-3.0F, -2.2F, -13.3F, 6.0F, 6.0F, 8.0F, 0.0F, false);

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 7.0F, 1.0F);
		Body.setTextureOffset(0, 42).addBox(-7.0F, -5.0F, -12.0F, 14.0F, 10.0F, 24.0F, 0.0F, false);
		Body.setTextureOffset(0, 61).addBox(-5.0F, -2.0F, 12.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);
		Body.setTextureOffset(0, 61).addBox(2.0F, -2.0F, 12.0F, 3.0F, 3.0F, 2.0F, 0.0F, false);

		Wing0 = new ModelRenderer(this);
		Wing0.setRotationPoint(-7.0F, 9.0F, 0.0F);
		setRotationAngle(Wing0, 0.0F, -0.2618F, 0.0F);
		Wing0.setTextureOffset(16, 25).addBox(-6.0819F, -1.0F, -7.6223F, 9.0F, 1.0F, 16.0F, 0.0F, false);

		Wing1 = new ModelRenderer(this);
		Wing1.setRotationPoint(7.0F, 9.0F, 0.0F);
		setRotationAngle(Wing1, 0.0F, 0.2618F, 0.0F);
		Wing1.setTextureOffset(16, 25).addBox(-3.1148F, -1.0F, -7.7238F, 9.0F, 1.0F, 16.0F, 0.0F, false);

		Leg0 = new ModelRenderer(this);
		Leg0.setRotationPoint(-5.0F, 12.0F, -7.0F);
		Leg0.setTextureOffset(0, 47).addBox(-1.5F, -0.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Leg0.setTextureOffset(12, 52).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Leg0.setTextureOffset(0, 54).addBox(-1.5F, 9.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Leg1 = new ModelRenderer(this);
		Leg1.setRotationPoint(5.0F, 12.0F, -7.0F);
		Leg1.setTextureOffset(0, 47).addBox(-1.5F, -0.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Leg1.setTextureOffset(12, 52).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Leg1.setTextureOffset(0, 54).addBox(-1.5F, 9.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Leg2 = new ModelRenderer(this);
		Leg2.setRotationPoint(-5.0F, 12.0F, 9.0F);
		Leg2.setTextureOffset(0, 47).addBox(-1.5F, -0.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Leg2.setTextureOffset(12, 52).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Leg2.setTextureOffset(0, 54).addBox(-1.5F, 9.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);

		Leg3 = new ModelRenderer(this);
		Leg3.setRotationPoint(5.0F, 12.0F, 9.0F);
		Leg3.setTextureOffset(0, 47).addBox(-1.5F, -0.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
		Leg3.setTextureOffset(12, 52).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, false);
		Leg3.setTextureOffset(0, 54).addBox(-1.5F, 9.1F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, false);
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red,
			float green, float blue, float alpha) {
		Head.render(matrixStack, buffer, packedLight, packedOverlay);
		Body.render(matrixStack, buffer, packedLight, packedOverlay);
		Wing0.render(matrixStack, buffer, packedLight, packedOverlay);
		Wing1.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg0.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg1.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg2.render(matrixStack, buffer, packedLight, packedOverlay);
		Leg3.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
		this.Leg2.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Leg3.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Head.rotateAngleY = f3 / (180F / (float) Math.PI);
		this.Head.rotateAngleX = f4 / (180F / (float) Math.PI);
		this.Leg0.rotateAngleX = MathHelper.cos(f * 1.0F) * 1.0F * f1;
		this.Leg1.rotateAngleX = MathHelper.cos(f * 1.0F) * -1.0F * f1;
		this.Wing1.rotateAngleZ = MathHelper.cos(f * 0.6662F) * f1;
		this.Wing0.rotateAngleZ = MathHelper.cos(f * 0.6662F + (float) Math.PI) * f1;
	}
}