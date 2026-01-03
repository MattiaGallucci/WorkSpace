import React, { useState } from 'react';
import { Shield, Music, Percent as Soccer, Plane, BarChart3 } from 'lucide-react';
import ProjectCard from './ProjectCard';

export interface Project {
  id: string;
  title: string;
  period: string;
  course: string;
  description: string;
  teammates?: string;
  icon: React.ReactNode;
  tags: string[];
}

const ProjectsSection: React.FC = () => {
  const projects: Project[] = [
    {
      id: 'vulnerability',
      title: 'Vulnerability Detection in Smart Contracts',
      period: 'In corso (2025)',
      course: 'Tirocinio',
      description: 'Durante il mio tirocinio sto lavorando allo studio e all\'applicazione di soluzioni basate su LLM (Large Language Models) per l\'identificazione automatica di vulnerabilità nei contratti intelligenti. Un progetto che fonde AI e sicurezza in un contesto altamente innovativo.',
      icon: <Shield className="h-12 w-12 text-teal-600 dark:text-teal-400" />,
      tags: ['AI', 'Sicurezza', 'Smart Contracts', 'LLM']
    },
    {
      id: 'goalguru',
      title: 'GoalGuru',
      period: '2024 - 2025',
      course: 'Fondamenti di Intelligenza Artificiale',
      description: 'GoalGuru è un sistema di previsione dei risultati calcistici che utilizza una rete neurale addestrata su dati storici e trend attuali. Un perfetto equilibrio tra sport e intelligenza artificiale.',
      teammates: 'Progetto sviluppato in team con Choaib Goumri.',
      icon: <Soccer className="h-12 w-12 text-teal-600 dark:text-teal-400" />,
      tags: ['AI', 'Machine Learning', 'Data Analysis', 'Sport']
    },
    {
      id: 'swagged',
      title: 'SwaGGed',
      period: '2024 - 2025',
      course: 'Ingegneria del Software',
      description: 'SwaGGed è una piattaforma social pensata per i veri appassionati di musica: offre articoli, recensioni, notizie e interviste dal mondo musicale. Un progetto stimolante per approfondire architetture software e dinamiche di user experience.',
      teammates: 'Progetto sviluppato in team con Choaib Goumri.',
      icon: <Music className="h-12 w-12 text-teal-600 dark:text-teal-400" />,
      tags: ['Web Development', 'UX/UI', 'Social Media', 'Music']
    },
    {
      id: 'jewelry',
      title: 'G&G Jewelry',
      period: '2023 - 2024',
      course: 'Tecnologie Software per il Web',
      description: 'Un sito e-commerce elegante e funzionale, creato per valorizzare la vendita online di gioielli artigianali di alta qualità. Un\'esperienza utile per apprendere le logiche del web development e dell\'interfaccia utente.',
      teammates: 'Progetto sviluppato in team con Choaib Goumri.',
      icon: <Shield className="h-12 w-12 text-teal-600 dark:text-teal-400" />,
      tags: ['E-commerce', 'Web Design', 'UX/UI']
    },
    {
      id: 'crime-analysis',
      title: 'Analisi Criminalità e Disoccupazione',
      period: '2023 - 2024',
      course: 'Calcolo delle Probabilità e Statistica Matematica',
      description: 'Questo progetto esplora la possibile correlazione tra tasso di disoccupazione e criminalità in Italia, utilizzando metodi statistici e dataset pubblici. Un viaggio tra dati, interpretazioni e modelli predittivi.',
      icon: <BarChart3 className="h-12 w-12 text-teal-600 dark:text-teal-400" />,
      tags: ['Data Analysis', 'Statistics', 'Research']
    },
    {
      id: 'airport',
      title: 'Sistema di Gestione Aeroportuale',
      period: '2023 - 2024',
      course: 'Base di Dati',
      description: 'Progettazione e implementazione di un sistema gestionale per aeroporti, con particolare attenzione alla modellazione del database e alla gestione dei flussi operativi. Un progetto perfetto per approfondire SQL e progettazione ER.',
      icon: <Plane className="h-12 w-12 text-teal-600 dark:text-teal-400" />,
      tags: ['Database', 'SQL', 'System Design']
    }
  ];

  const [hoveredProject, setHoveredProject] = useState<string | null>(null);

  return (
    <section id="projects" className="py-20 bg-gray-50 dark:bg-gray-800">
      <div className="container mx-auto px-4">
        <h2 className="text-3xl font-bold mb-2 text-center text-gray-800 dark:text-white">
          <span className="text-teal-600 dark:text-teal-400">💻</span> Progetti
        </h2>
        <p className="text-center text-gray-600 dark:text-gray-400 mb-12 max-w-2xl mx-auto">
          Nel mio percorso universitario ho avuto l'opportunità di mettermi alla prova in diversi progetti, 
          spesso in team, dove ho potuto applicare le conoscenze teoriche in contesti pratici.
        </p>
        
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-8">
          {projects.map((project) => (
            <ProjectCard 
              key={project.id}
              project={project}
              isHovered={hoveredProject === project.id}
              onHover={() => setHoveredProject(project.id)}
              onLeave={() => setHoveredProject(null)}
            />
          ))}
        </div>
      </div>
    </section>
  );
};

export default ProjectsSection;