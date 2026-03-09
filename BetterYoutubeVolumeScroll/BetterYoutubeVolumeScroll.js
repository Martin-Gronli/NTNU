// ==UserScript==
// @name         BetterYouTubeVolumeScroll
// @version      1.0
// @description  Scroll to adjust volume on YouTube
// @author       Martin-Gronli
// @match        *://www.youtube.com/*
// ==/UserScript==

var changeAmount = 2; // Volume change per scroll step

(function() {
    'use strict';

    function adjustVolume(event) {
        const videoPlayer = document.querySelector('#movie_player');
        if (videoPlayer) {
            const currentVolume = videoPlayer.getVolume();
            const delta = event.deltaY;
            let newVolume = currentVolume + (delta < 0 ? changeAmount : -changeAmount);
            newVolume = Math.max(0, Math.min(100, newVolume));
            videoPlayer.setVolume(newVolume);
            if (newVolume > 0 && videoPlayer.isMuted()) videoPlayer.unMute();
            event.preventDefault();
            event.stopImmediatePropagation();
            showOverlay(newVolume);
        }
    }

    function getOverlayBottom(playerElement, overlayHeight) {
        // Default position: just above the control bar
        let bottom = 80;

        // Check if subtitles are visible and where they are
        const captionWindow = playerElement.querySelector('.caption-window');
        if (captionWindow && window.getComputedStyle(captionWindow.parentElement).display !== 'none') {
            const playerRect = playerElement.getBoundingClientRect();
            const captionRect = captionWindow.getBoundingClientRect();
            const captionBottom = playerRect.bottom - captionRect.top; // distance from player bottom to caption top

            // If our bar at default position would overlap captions, push above them
            if (captionBottom > bottom) {
                bottom = captionBottom + overlayHeight + 10;
            }
        }

        return bottom;
    }

    function showOverlay(volumePercent) {
        const playerElement = document.querySelector('#movie_player');
        if (!playerElement) return;

        let overlay = playerElement.querySelector('#volume-overlay');
        if (!overlay) {
            overlay = document.createElement('div');
            overlay.id = 'volume-overlay';
            overlay.style.cssText = `
                position: absolute;
                z-index: 40;
                pointer-events: none;
                display: none;
                flex-direction: column;
                align-items: center;
                left: 50%;
                transform: translateX(-50%);
                padding: 18px 32px;
                background: rgba(0, 0, 0, 0.82);
                border-radius: 8px;
                box-shadow: 0 4px 16px rgba(0,0,0,0.18);
                transition: opacity 0.2s ease, bottom 0.15s ease;
                font-family: "YouTube Sans", Roboto, Arial, sans-serif;
            `;
            const barRow = document.createElement('div');
            barRow.style.cssText = 'display: flex; flex-direction: row; align-items: center; gap: 12px;';
            const barContainer = document.createElement('div');
            barContainer.style.cssText = 'width: 180px; height: 8px; background: rgba(255,255,255,0.2); border-radius: 4px; overflow: hidden;';
            const barFill = document.createElement('div');
            barFill.id = 'volume-overlay-fill';
            barFill.style.cssText = 'height: 100%; background: #696969; width: 0%; transition: width 0.1s ease-out;';
            barContainer.appendChild(barFill);
            const percentText = document.createElement('span');
            percentText.id = 'volume-overlay-percent';
            percentText.style.cssText = 'color: #fff; font-size: 1.6em; min-width: 36px; text-align: right; font-variant-numeric: tabular-nums; user-select: none;';
            percentText.textContent = '0%';
            barRow.appendChild(barContainer);
            barRow.appendChild(percentText);
            overlay.appendChild(barRow);
            playerElement.appendChild(overlay);
        }

        const fillElement = overlay.querySelector('#volume-overlay-fill');
        const percentElement = overlay.querySelector('#volume-overlay-percent');
        const vol = Math.round(volumePercent);
        fillElement.style.width = `${vol}%`;
        if (percentElement) percentElement.textContent = `${vol}%`;

        // Show first so we can measure its height
        overlay.style.display = 'flex';
        overlay.style.opacity = '1';

        // Now position it, moving up if it would cover subtitles
        const overlayHeight = overlay.getBoundingClientRect().height;
        const bottom = getOverlayBottom(playerElement, overlayHeight);
        overlay.style.bottom = `${bottom}px`;

        clearTimeout(window.volTimer);
        window.volTimer = setTimeout(() => {
            overlay.style.opacity = '0';
            setTimeout(() => { overlay.style.display = 'none'; }, 200);
        }, 1000);
    }

    window.addEventListener('wheel', function(event) {
        if (event.target.closest('#movie_player')) {
            adjustVolume(event);
        }
    }, { passive: false, capture: true });

})();