import React, { useState, useEffect } from 'react';
import { Send, Check, AlertCircle } from 'lucide-react';
import emailjs from 'emailjs-com';

const ContactSection: React.FC = () => {
  const [formState, setFormState] = useState({
    name: '',
    email: '',
    message: '',
  });
  
  const [errors, setErrors] = useState<{
    name?: string;
    email?: string;
    message?: string;
  }>({});
  
  const [isSubmitting, setIsSubmitting] = useState(false);
  const [submitStatus, setSubmitStatus] = useState<'idle' | 'success' | 'error'>('idle');

  // Initialize EmailJS
  useEffect(() => {
    emailjs.init("IMm7EdT6s3g055n4L"); // Replace with your actual EmailJS User ID
  }, []);

  const validateForm = () => {
    const newErrors: {
      name?: string;
      email?: string;
      message?: string;
    } = {};
    
    if (!formState.name.trim()) {
      newErrors.name = 'Il nome è richiesto';
    }
    
    if (!formState.email.trim()) {
      newErrors.email = 'L\'email è richiesta';
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formState.email)) {
      newErrors.email = 'Inserisci un indirizzo email valido';
    }
    
    if (!formState.message.trim()) {
      newErrors.message = 'Il messaggio è richiesto';
    } else if (formState.message.length < 10) {
      newErrors.message = 'Il messaggio deve essere più lungo di 10 caratteri';
    }
    
    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement | HTMLTextAreaElement>) => {
    const { name, value } = e.target;
    setFormState(prev => ({
      ...prev,
      [name]: value
    }));
    
    // Clear the error for this field
    if (errors[name as keyof typeof errors]) {
      setErrors(prev => ({
        ...prev,
        [name]: undefined
      }));
    }
  };

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    
    if (!validateForm()) {
      return;
    }
    
    setIsSubmitting(true);
    
    // Prepare template parameters
    const templateParams = {
      from_name: formState.name,
      from_email: formState.email,
      message: formState.message,
      to_email: 'mattiagal2003@gmail.com'
    };
    
    emailjs.send(
      'service_b73qeen', // Replace with your EmailJS service ID
      'template_zty93xf', // Replace with your EmailJS template ID
      templateParams
    )

    // Send email using EmailJS
    emailjs.send(
      'service_b73qeen', // Replace with your EmailJS service ID
      'template_nyaw2pg', // Replace with your EmailJS template ID
      templateParams
    )
      .then(() => {
        setIsSubmitting(false);
        setSubmitStatus('success');
        
        // Reset form after successful submission
        setFormState({
          name: '',
          email: '',
          message: ''
        });
        
        // Reset status after 5 seconds
        setTimeout(() => {
          setSubmitStatus('idle');
        }, 5000);
      })
      .catch((error) => {
        console.error('Email sending failed:', error);
        setIsSubmitting(false);
        setSubmitStatus('error');
      });
  };

  return (
    <section id="contact" className="py-20 bg-gray-50 dark:bg-gray-800">
      <div className="container mx-auto px-4">
        <h2 className="text-3xl font-bold mb-2 text-center text-gray-800 dark:text-white">
          <span className="text-teal-600 dark:text-teal-400">📬</span> Contattami
        </h2>
        <p className="text-center text-gray-600 dark:text-gray-400 mb-12 max-w-2xl mx-auto">
          Se sei curioso di saperne di più sui miei progetti, se vuoi collaborare a qualcosa di stimolante o semplicemente scambiare idee su AI, sicurezza o sviluppo software, scrivimi!
        </p>
        
        <div className="max-w-2xl mx-auto">
          <div className="bg-white dark:bg-gray-900 rounded-lg shadow-md p-8">
            <form onSubmit={handleSubmit}>
              <div className="mb-6">
                <label htmlFor="name" className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                  Nome
                </label>
                <input
                  type="text"
                  id="name"
                  name="name"
                  value={formState.name}
                  onChange={handleChange}
                  className={`w-full px-4 py-2 border rounded-md focus:ring focus:ring-teal-200 focus:border-teal-500 dark:bg-gray-800 dark:border-gray-700 dark:text-white ${
                    errors.name ? 'border-red-500 dark:border-red-500' : 'border-gray-300'
                  }`}
                  placeholder="Il tuo nome"
                />
                {errors.name && (
                  <p className="mt-1 text-sm text-red-500">{errors.name}</p>
                )}
              </div>
              
              <div className="mb-6">
                <label htmlFor="email" className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                  Email
                </label>
                <input
                  type="email"
                  id="email"
                  name="email"
                  value={formState.email}
                  onChange={handleChange}
                  className={`w-full px-4 py-2 border rounded-md focus:ring focus:ring-teal-200 focus:border-teal-500 dark:bg-gray-800 dark:border-gray-700 dark:text-white ${
                    errors.email ? 'border-red-500 dark:border-red-500' : 'border-gray-300'
                  }`}
                  placeholder="La tua email"
                />
                {errors.email && (
                  <p className="mt-1 text-sm text-red-500">{errors.email}</p>
                )}
              </div>
              
              <div className="mb-6">
                <label htmlFor="message" className="block text-sm font-medium text-gray-700 dark:text-gray-300 mb-2">
                  Messaggio
                </label>
                <textarea
                  id="message"
                  name="message"
                  value={formState.message}
                  onChange={handleChange}
                  rows={5}
                  className={`w-full px-4 py-2 border rounded-md focus:ring focus:ring-teal-200 focus:border-teal-500 dark:bg-gray-800 dark:border-gray-700 dark:text-white ${
                    errors.message ? 'border-red-500 dark:border-red-500' : 'border-gray-300'
                  }`}
                  placeholder="Il tuo messaggio"
                />
                {errors.message && (
                  <p className="mt-1 text-sm text-red-500">{errors.message}</p>
                )}
              </div>
              
              <div className="flex items-center justify-end">
                <button
                  type="submit"
                  disabled={isSubmitting || submitStatus === 'success'}
                  className={`px-6 py-3 rounded-md text-white font-medium flex items-center space-x-2 transition-colors ${
                    isSubmitting 
                      ? 'bg-gray-400 cursor-not-allowed' 
                      : submitStatus === 'success'
                        ? 'bg-green-500 hover:bg-green-600'
                        : 'bg-teal-600 hover:bg-teal-700 dark:bg-teal-500 dark:hover:bg-teal-600'
                  }`}
                >
                  {isSubmitting ? (
                    <>
                      <svg className="animate-spin -ml-1 mr-3 h-5 w-5 text-white" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                        <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4"></circle>
                        <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z"></path>
                      </svg>
                      <span>Invio in corso...</span>
                    </>
                  ) : submitStatus === 'success' ? (
                    <>
                      <Check className="h-5 w-5" />
                      <span>Messaggio inviato!</span>
                    </>
                  ) : (
                    <>
                      <Send className="h-5 w-5" />
                      <span>Invia messaggio</span>
                    </>
                  )}
                </button>
              </div>
              
              {submitStatus === 'error' && (
                <div className="mt-4 p-3 bg-red-50 text-red-700 rounded-md flex items-start">
                  <AlertCircle className="h-5 w-5 mr-2 flex-shrink-0 mt-0.5" />
                  <p>Si è verificato un errore durante l'invio. Riprova più tardi.</p>
                </div>
              )}
            </form>
          </div>
        </div>
      </div>
    </section>
  );
};

export default ContactSection;