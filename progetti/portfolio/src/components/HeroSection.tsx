import React from 'react';
import { ChevronDown } from 'lucide-react';

const HeroSection: React.FC = () => {
  const scrollToAbout = () => {
    const element = document.getElementById('about');
    if (element) {
      window.scrollTo({
        top: element.offsetTop - 80,
        behavior: 'smooth',
      });
    }
  };

  return (
    <section className="relative min-h-screen flex items-center justify-center bg-gradient-to-br from-gray-900 via-gray-800 to-teal-900 overflow-hidden">
      {/* Animated Particles */}
      <div className="absolute inset-0 overflow-hidden">
        {Array.from({ length: 20 }).map((_, index) => (
          <div
            key={index}
            className="absolute rounded-full bg-teal-500 opacity-10"
            style={{
              top: `${Math.random() * 100}%`,
              left: `${Math.random() * 100}%`,
              width: `${Math.random() * 200 + 50}px`,
              height: `${Math.random() * 200 + 50}px`,
              animation: `float ${Math.random() * 20 + 10}s linear infinite`,
              animationDelay: `${Math.random() * 5}s`,
            }}
          />
        ))}
      </div>
      
      <div className="container mx-auto px-4 z-10 text-center">
        <div className="relative inline-block mb-6">
          <div className="w-20 h-20 md:w-24 md:h-24 rounded-full bg-teal-500/20 p-1.5 mx-auto">
            <div className="w-full h-full rounded-full bg-white/10 backdrop-blur-sm flex items-center justify-center">
              <span className="text-3xl md:text-4xl font-bold text-white">MG</span>
            </div>
          </div>
        </div>
        
        <h1 className="text-4xl md:text-6xl font-bold text-white mb-4">
          Mattia Gallucci
        </h1>
        
        <p className="text-xl md:text-2xl text-teal-300 font-light mb-8">
          Studente di Informatica • Appassionato di Sicurezza e AI
        </p>
        
        <div className="max-w-3xl mx-auto mb-12 text-gray-300 text-lg md:text-xl">
          <p>
            Benvenuto nel mio portfolio, dove condivido i miei progetti, competenze e passioni
          </p>
        </div>
        
        <button
          onClick={scrollToAbout}
          className="animate-bounce mt-8 p-2 rounded-full bg-white/10 hover:bg-white/20 transition-colors duration-300"
          aria-label="Scorri verso il basso"
        >
          <ChevronDown className="w-6 h-6 text-white" />
        </button>
      </div>
      
      {/* Gradient Overlay */}
      <div className="absolute bottom-0 left-0 right-0 h-24 bg-gradient-to-t from-white dark:from-gray-900 to-transparent" />
    </section>
  );
};

export default HeroSection;