from multicolorcaptcha import CaptchaGenerator

# Captcha image size number (2 -> 640x360)
CAPCTHA_SIZE_NUM = 5

# Create Captcha Generator object of specified size
generator = CaptchaGenerator(CAPCTHA_SIZE_NUM)

# Generate a captcha image
captcha = generator.gen_captcha_image(difficult_level=3)
math_captcha = generator.gen_math_captcha_image(difficult_level=2)

# Get information of standard captcha
image = captcha.image
characters = captcha.characters

# Get information of math captcha
math_image = math_captcha.image
math_equation_string = math_captcha.equation_str
math_equation_result = math_captcha.equation_result

# Save the images to files
image.save("image.png", "png")
math_image.save("math.png", "png")